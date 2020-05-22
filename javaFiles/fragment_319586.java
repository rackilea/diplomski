public class ConverterActivity extends Activity {

EditText convertValue ;
TextView convertResult;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_converter);

 convertValue = (EditText) findViewById(R.id.et_value_convert);
 convertResult = (TextView) findViewById(R.id.txt_result);
}

 ///YOUR CODE HERE