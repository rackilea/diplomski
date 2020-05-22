public class activityresult1 extends Activity {


EditText frq, fnq, foodordershow;
Button suborder;
TextView noodlequantity, ricequantity;
private static final int REQUEST_CODE = 10;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_activityresult2);

    fnq = (EditText) findViewById(R.id.fnq);
    frq = (EditText) findViewById(R.id.frq);
    noodlequantity = (TextView) findViewById(R.id.noodlequantity);
    ricequantity = (TextView) findViewById(R.id.ricequantity);
    suborder = (Button) findViewById(R.id.suborder);


    suborder.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            String strnoodlequantity = noodlequantity.getText().toString();
            String strricequantity = ricequantity.getText().toString();
            Intent intent = new Intent(getApplicationContext(), activityresult2.class);
            Bundle bundle = new Bundle();
            bundle.putString("Noodle quantity", strnoodlequantity);
            bundle.putString("Rice quantity", strricequantity);
            //intent.putExtra("Noodle quantity", strnoodlequantity);
            //intent.putExtra("Rice quantity", strricequantity);
            intent.putExtras(bundle);
            startActivityForResult(intent, REQUEST_CODE);
        }
    });
}

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
        if (data.hasExtra("Food Ordered:")) {
            String result = data.getExtras().getString("Food Ordered:");
            if (result != null && result.length() > 0) {
                foodordershow.setText("Food Ordered: " + result);
            }
        }
    }
}