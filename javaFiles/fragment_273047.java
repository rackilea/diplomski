public class SignUp2 extends Activity implements
AdapterView.OnItemSelectedListener {

//declare here
Spinner spinner4;
Spinner spinner2;
Spinner spinner3;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sign_up2);

    //initialize here after you have called setContentView()
    spinner4 = (Spinner) findViewById(R.id.spinner4);
    spinner2 = (Spinner) findViewById(R.id.spinner2);
    spinner3 = (Spinner) findViewById(R.id.spinner3);