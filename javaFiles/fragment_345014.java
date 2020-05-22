public class MainActivity extends Activity {

private EditText Weight, Height;
private TextView BMI, BMItext;
private Button button;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    BMItext = (TextView) findViewById(R.id.BMItext);        
    BMI = (TextView) findViewById(R.id.BMI);        
    Weight = (EditText) findViewById(R.id.Weight);
    Height = (EditText) findViewById(R.id.Height);  
    button = (Button) findViewById(R.id.button);

    button.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
           Double Weightnum= Weight.getText().toString();
           Double WeightHeight = Weight.getText().toString()*Height.getText().toString();
            Double calculator = Weightnum/WeightHeight;
            BMI.setText("Your BMI is:" + calculator);
if(calculator >= 0 && calculator < 22.01)
    {
BMItext.settext("That is too low, you are underweight.\nEat regularly and put on some weight.");
                }else if(calculator >= 22.01 && calculator < 25.01){
        BMItext.settext("That is normal, maintain your healthy lifestyle.");
    }else if(calculator >= 25.01 && calculator < 30.01){
        BMItext.settext("That is high, you are overweight!\nGet on a diet and exercise regularly.");
    }else if(bmi >= 30.01 && bmi < 40.01){
        BMItext.settext("That is very high, you are OBESE!\nGet on a diet and exercise as often as you can.");
    }else{
        BMItext.settext("That is way too high, you are SEVERELY OBESE!\nGet on a diet asap and exercise everyday!");
    }

        }
    });

    }
 }