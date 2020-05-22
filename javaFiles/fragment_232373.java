public class Age extends Activity {


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_age);

    Button getage = (Button) findViewById(R.id.getage);
    EditText ddtext = (EditText) findViewById(R.id.dd);

    EditText mmtext = (EditText) findViewById(R.id.mm);

    EditText yyyytext = (EditText) findViewById(R.id.yyyy);

    final TextView output = (TextView) findViewById(R.id.output);

    getage.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

             String dds = ddtext.getText().toString();
             int dd = Integer.parseInt(dds);

             String mms = mmtext.getText().toString();

             int mm = Integer.parseInt(mms);  

             String yyyys = yyyytext.getText().toString();
             int yyyy = Integer.parseInt(yyyys); 
            output.setText("you wrote:" + (dd + mm + yyyy));
        }
    });
}}