package yardenoren.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static double round(double value) {
        long factor = (long) Math.pow(10, 2);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public void calculate(View view) {

        double tipRate = 0.12;
        CheckBox box = (CheckBox) findViewById(R.id.chkRound);
        TextView Tip = (TextView) findViewById(R.id.txtTipResult);
        EditText amountText = (EditText) findViewById(R.id.edtBillAmount);
        String outTip = "Tip: ";
        if (amountText.length() < 1)
        {
            Tip.setText(outTip);
            return;
        }
        if (amountText.length() > 9)
        {
            Tip.setText("I only support amounts with 1-9 digits");
            return;
        }
        double amonut = Double.parseDouble(amountText.getText().toString());
        double tip = amonut * tipRate;

        if (box.isChecked()) {
            tip = Math.round(tip);
            outTip += Integer.toString((int) round(tip));
        }else {
            outTip += Double.toString(round(tip));
        }
        outTip+=" $";
        Tip.setText(outTip);
    }
}
