import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {

    private String array_spinner1[];
    private String array_spinner2[];
    private EditText input1;
    private EditText input2;
    Spinner topSpinner;
    Spinner bottomSpinner;
    String topSpinnerVal;
    String bottomSpinnerVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topSpinner = (Spinner) findViewById(R.id.input1Sp);
        bottomSpinner = (Spinner) findViewById(R.id.input2Sp);
        array_spinner1=new String[3];
        array_spinner1[0]="Celsius";
        array_spinner1[1]="Fahrenheit";
        array_spinner1[2]="Kelvin";
        array_spinner2=new String[3];
        array_spinner2[0]="Celsius";
        array_spinner2[1]="Fahrenheit";
        array_spinner2[2]="Kelvin";
        ArrayAdapter adapter1 = new ArrayAdapter(this,
        android.R.layout.simple_spinner_item, array_spinner1);
        ArrayAdapter adapter2 = new ArrayAdapter(this,
        android.R.layout.simple_spinner_item, array_spinner2);
        topSpinner.setAdapter(adapter1);
        bottomSpinner.setAdapter(adapter2);
        input1 = (EditText) findViewById(R.id.input1TB);
        input2 = (EditText) findViewById(R.id.input2TB);
    }

    public void onClick(View button) {
        topSpinnerVal = topSpinner.getSelectedItem().toString();
        bottomSpinnerVal = bottomSpinner.getSelectedItem().toString();
        Double valTop = Double.parseDouble(input1.getText().toString());
        Double valBottom = Double.parseDouble(input2.getText().toString());
        switch (button.getId()) {
        case R.id.topToBottomBt:
            if (input1.getText().length() == 0){
                Toast.makeText(this, "Requested conversion is empty", Toast.LENGTH_LONG).show();
            return;
            }
            if (topSpinnerVal.equals("Celsius")) {
                if (bottomSpinnerVal.equals("Celsius")) {

                }
            }
        case R.id.bottomToTopBt:

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}