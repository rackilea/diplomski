public class MainAcivity extends Activity{
    private RadioGroup group1;
    //Declare other RadioGroup group2,group3...group 10. if you intend
    //to access them outside of onCreate()
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        group1 = (RadioGroup)findViewById(R.id.que1_rG);
        ...
    }
      public void submitButton(View view) {
        int checkedRadio1= group1.getCheckedRadioButtonId();
        Toast.makeText(this,"Score is : " + score,Toast.LENGTH_SHORT).show();
        Log.v("MainActivity","Score is  " + score);
        score = 0;
    }
}