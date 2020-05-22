import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  Spinner operation;
  Button calculate;
  EditText input1;
  EditText input2;
  TextView result;
  String val;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    operation = findViewById(R.id.spinner1);
    calculate = findViewById(R.id.button1);
    input1 = findViewById(R.id.input1);
    input2 = findViewById(R.id.input2);
    result = findViewById(R.id.textView);

    calculate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String val1 = input1.getText().toString();
            String val2 = input2.getText().toString();
            if (val.equals("add")) {
                result.setText(String.valueOf(Integer.parseInt(val1) + Integer.parseInt(val2)));
            }
            if (val.equals("sub")) {
                result.setText(String.valueOf(Integer.parseInt(val1) - Integer.parseInt(val2)));
            }
            if (val.equals("multiply")) {
                result.setText(String.valueOf(Integer.parseInt(val1) * Integer.parseInt(val2)));
            }
            if (val.equals("divide")) {
                result.setText(String.valueOf(Integer.parseInt(val1) / Integer.parseInt(val2)));
            }
        }
    });

    operation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            val = operation.getSelectedItem().toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    });
  }
}