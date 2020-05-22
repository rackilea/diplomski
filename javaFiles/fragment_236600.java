public class activityresult2 extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_activityresult1);

    Bundle extras = getIntent().getExtras();
    String strfnq = extras.getString("Noodle Quantity");
    String strfrq = extras.getString("Rice Quantity");
    TextView foodorders = (TextView) findViewById(R.id.foodordershow);
    foodorders.setText(getIntent().getExtras().getString("Quantity"));

    foodorders = (TextView) findViewById(R.id.foodordershow);
    foodorders.setText("Welcome, " + strfnq + " + strfrq + ");
    //finish();


}