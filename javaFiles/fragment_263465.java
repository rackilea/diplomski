public class MainActivity extends AppCompatActivity {
private double counter = 0;
private double sum = 0;
private String value;
TextView textGemiddelde;
EditText EditText1;
EditText EditText2;
EditText EditText3;
EditText EditText4;
EditText EditText5;
EditText EditText6;
EditText EditText7;
EditText EditText8;
EditText EditText9;
EditText EditText10;
EditText EditText_1;
EditText EditText_2;
EditText EditText_3;
EditText EditText_4;
EditText EditText_5;
EditText EditText_6;
EditText EditText_7;
EditText EditText_8;
EditText EditText_9;
EditText EditText_10;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    EditText1 = (EditText) findViewById(R.id.EditText1);

    EditText2 = (EditText) findViewById(R.id.EditText2);

    EditText3 = (EditText) findViewById(R.id.EditText3);

    EditText4 = (EditText) findViewById(R.id.EditText4);

    EditText5 = (EditText) findViewById(R.id.EditText5);

    EditText6 = (EditText) findViewById(R.id.EditText6);

    EditText7 = (EditText) findViewById(R.id.EditText7);

    EditText8 = (EditText) findViewById(R.id.EditText8);

    EditText9 = (EditText) findViewById(R.id.EditText9);

    EditText10 = (EditText) findViewById(R.id.EditText10);

    EditText_1 = (EditText) findViewById(R.id.EditText_1);

    EditText_2 = (EditText) findViewById(R.id.EditText_2);

    EditText_3 = (EditText) findViewById(R.id.EditText_3);

    EditText_4 = (EditText) findViewById(R.id.EditText_4);

    EditText_5 = (EditText) findViewById(R.id.EditText_5);

    EditText_6 = (EditText) findViewById(R.id.EditText_6);

    EditText_7 = (EditText) findViewById(R.id.EditText_7);

    EditText_8 = (EditText) findViewById(R.id.EditText_8);

    EditText_9 = (EditText) findViewById(R.id.EditText_9);

    EditText_10 = (EditText) findViewById(R.id.EditText_10);

    textGemiddelde = (TextView)
            findViewById(R.id.Gemiddelde);
    Button button = (Button) findViewById(R.id.Button);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // handle click
           sum = sum();
            textGemiddelde.append(calculate());
        }
    });
}

public double sum() {

    sum = 0;
    counter = 0;
    double cijfer1 = ParseDouble(EditText1.getText().toString());


    double cijfer2 = ParseDouble(EditText2.getText().toString());


    double cijfer3 = ParseDouble(EditText3.getText().toString());


    double cijfer4 = ParseDouble(EditText4.getText().toString());


    double cijfer5 = ParseDouble(EditText5.getText().toString());


    double cijfer6 = ParseDouble(EditText6.getText().toString());


    double cijfer7 = ParseDouble(EditText7.getText().toString());


    double cijfer8 = ParseDouble(EditText8.getText().toString());


    double cijfer9 = ParseDouble(EditText9.getText().toString());


    double cijfer10 = ParseDouble(EditText10.getText().toString());


    double weging1 = ParseDouble(EditText_1.getText().toString());


    double weging2 = ParseDouble(EditText_2.getText().toString());

    double weging3 = ParseDouble(EditText_3.getText().toString());

    double weging4 = ParseDouble(EditText_4.getText().toString());

    double weging5 = ParseDouble(EditText_5.getText().toString());

    double weging6 = ParseDouble(EditText_6.getText().toString());

    double weging7 = ParseDouble(EditText_7.getText().toString());

    double weging8 = ParseDouble(EditText_8.getText().toString());

    double weging9 = ParseDouble(EditText_9.getText().toString());

    double weging10 = ParseDouble(EditText_10.getText().toString());


    if(!TextUtils.isEmpty(EditText1.getText().toString()) &&
            !TextUtils.isEmpty(EditText_1.getText().toString())) {
        this.sum += cijfer1 * weging1;
        this.counter++;
    } else {

    }

    if(!TextUtils.isEmpty(EditText2.getText().toString()) &&
            !TextUtils.isEmpty(EditText_2.getText().toString())) {
        this.sum += cijfer2 * weging2;
        this.counter++;
    } else {

    }

    if(!TextUtils.isEmpty(EditText3.getText().toString()) &&
            !TextUtils.isEmpty(EditText_3.getText().toString())) {
        this.sum += cijfer3 * weging3;
        this.counter++;
    } else {

    }

    if(!TextUtils.isEmpty(EditText4.getText().toString()) &&
            !TextUtils.isEmpty(EditText_4.getText().toString())) {
        this.sum += cijfer4 * weging4;
        this.counter++;
    } else {

    }

    if(!TextUtils.isEmpty(EditText5.getText().toString()) &&
            !TextUtils.isEmpty(EditText_5.getText().toString())) {
        this.sum += cijfer5 * weging5;
        this.counter++;
    } else {

    }

    if(!TextUtils.isEmpty(EditText6.getText().toString()) &&
            !TextUtils.isEmpty(EditText_6.getText().toString())) {
        this.sum += cijfer6 * weging6;
        this.counter++;
    } else {

    }

    if(!TextUtils.isEmpty(EditText7.getText().toString()) &&
            !TextUtils.isEmpty(EditText_7.getText().toString())) {
        this.sum += cijfer7 * weging7;
        this.counter++;
    } else {

    }

    if(!TextUtils.isEmpty(EditText8.getText().toString()) &&
            !TextUtils.isEmpty(EditText_8.getText().toString())) {
        this.sum += cijfer8 * weging8;
        this.counter++;
    } else {

    }

    if(!TextUtils.isEmpty(EditText9.getText().toString()) &&
            !TextUtils.isEmpty(EditText_9.getText().toString())) {
        this.sum += cijfer9 * weging9;
        this.counter++;
    } else {

    }

    if(!TextUtils.isEmpty(EditText10.getText().toString()) && !TextUtils.isEmpty(EditText_10.getText().toString())) {
        this.sum += cijfer10 * weging10;
        this.counter++;
    } else {

    }

    return sum;
}

public double average() {
    if(couter == 0) return -1;
    return sum / counter;
}

public String calculate() {
    value = String.valueOf(average());
    return value;
}
double ParseDouble(String strNumber) {
    if (strNumber != null && strNumber.length() > 0) {
        try {
            return Double.parseDouble(strNumber);
        } catch(Exception e) {
            return -1;   // or some value to mark this field is wrong. or make a function validates field first ...
        }
    }
    else return 0;
}

}