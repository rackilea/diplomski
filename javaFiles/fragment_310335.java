public class Acceleration extends Activity {

    EditText etV0, etV1, etT0, etT1
    TextView tvAccResult;
    Button accC;
    double CetV0, CetV1, CetT0, CetT1, CtvAccResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_acceleration);

    initialize();

    accC.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {

    CetV0 = (Double.parseDouble(etV0.getText().toString()));
    CetV1 = (Double.parseDouble(etV1.getText().toString()));
    CetT0 = (Double.parseDouble(etT0.getText().toString()));`enter code here`
    CetT1 = (Double.parseDouble(etT1.getText().toString()));

    CtvAccResult = (double) ((CetV0 - CetV1) / (CetT0 - CetT1));
            tvAccResult.setText(Double.toString(CtvAccResult));
        }
    });

}

    private void initialize() {
        etV0 = (EditText) findViewById(R.id.etV0);
        etV1 = (EditText) findViewById(R.id.etV1);
        etT0 = (EditText) findViewById(R.id.etT0);
        etT1 = (EditText) findViewById(R.id.etT1);
        tvAccResult = (TextView) findViewById(R.id.tvAccResult);
        accC = (Button) findViewById(R.id.accC);

    }



 @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.acceleration, menu);
        return true;
    }

    }