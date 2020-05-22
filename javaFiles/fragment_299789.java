public class MainActivity extends AppCompatActivity {


EditText edtInput, edtSearch, edtOutPut;
Button btnCalculate;
int lastIndex = 0;
int count = 0;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    edtInput = (EditText) findViewById(R.id.edtInput);
    edtSearch = (EditText)findViewById(R.id.edtSearch);
    edtOutPut = (EditText)findViewById(R.id.edtOutPut);

    btnCalculate = (Button)findViewById(R.id.btnCalculate);

    btnCalculate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            count=0;
            lastIndex = 0;
            calculate();
        }
    });
}

private void calculate() {
    while(lastIndex != -1){

        lastIndex = edtInput.getText().toString().indexOf(edtSearch.getText().toString(),lastIndex);

        if(lastIndex != -1){
            count ++;
            lastIndex += edtSearch.getText().toString().length();
        }
    }
    edtOutPut.setText(""+(count*Integer.parseInt(edtSearch.getText().toString())));
}
}