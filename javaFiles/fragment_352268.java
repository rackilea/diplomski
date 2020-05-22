public class MainActivity extends ActionBarActivity {
EditText editFirst,editSecond,editAnswer;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.fragment_main);

    editFirst =  (EditText) findViewById(R.id.txtfirstnum);
   editSecond = (EditText) findViewById(R.id. txtsecondnum);
   editAnswer = (EditText) findViewById(R.id.txtanswer);

    Button btnAdd =  (Button) findViewById(R.id.btnAdd);
    Button btnprod =  (Button) findViewById(R.id.btnprod);

    btnAdd.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {

        double first= 0;
        double second=0;
        double sagot= 0;
        double sagot2 =0;   

            first=Double.parseDouble(editFirst.getText().toString());
            second=Double.parseDouble(editSecond.getText().toString());
            sagot= first + second;
            editAnswer.setText(String.valueOf(sagot));

        }
    });

    btnprod.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {

        double first= 0;
        double second=0;
        double sagot= 0;
        double sagot2 =0;   

            first=Double.parseDouble(editFirst.getText().toString());
            second=Double.parseDouble(editSecond.getText().toString());
            sagot2= first * second;
        editAnswer.setText(String.valueOf(sagot2));

        }
    });

}