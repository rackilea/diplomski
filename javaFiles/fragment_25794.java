//Convert.java

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Convert extends AppCompatActivity {

    EditText currency_input ;
    TextView answer;

    String input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.convert);

        // Views
        currency_input = (EditText) findViewById(R.id.editText_currency_input);
        answer = (TextView) findViewById(R.id.textView_convert_to);

        // Default value
        currency_input.setText("0.0");

        Spinner spinner_convert_from = (Spinner) findViewById(R.id.spinner_convert_from);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.currency_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_convert_from.setAdapter(adapter);

        // Add item selected listener
        spinner_convert_from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int pos,
                                       long id) {

                // Get input text 
                input = currency_input.getText().toString();

                if (pos == 0) {
                    USD();
                } else if (pos == 1) {
                    EUR();
                } else if (pos == 2) {
                    AUD();
                } else if (pos == 3) {
                    CAD();
                } else if (pos == 4) {
                    JPY();
                } else if (pos == 5) {
                    CHF();
                } else if (pos == 6) {
                    CNY();
                } else if (pos == 7) {
                    KRW();
                } else if (pos == 8) {
                    SEK();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void USD() {
        answer.setText(String.valueOf(Double.valueOf(input)*1.2798));
    }

    private void EUR() {
        answer.setText(String.valueOf(Double.valueOf(input)*1.14502));
    }

    private void AUD() {
        answer.setText(String.valueOf(Double.valueOf(input)*1.71911));
    }

    private void CAD() {
        answer.setText(String.valueOf(Double.valueOf(input)*1.7226));
    }

    private void JPY() {
        answer.setText(String.valueOf(Double.valueOf(input)*142.482));
    }

    private void CHF() {
        answer.setText(String.valueOf(Double.valueOf(input)* 1.24662));
    }

    private void CNY() {
        answer.setText(String.valueOf(Double.valueOf(input)* 8.7714));
    }

    private void KRW() {
        answer.setText(String.valueOf(Double.valueOf(input)*1430.8));
    }

    private void SEK() {
        answer.setText(String.valueOf(Double.valueOf(input)* 11.1187));
    }
}