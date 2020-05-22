public class MainActivity extends Activity {

    EditText message, password, username;  // these are called fields
    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//instantiate like this
        username = new EditText(this);
        password = (EditText) findViewById(R.id.editText2);
        message = (EditText) findViewById(R.id.editText3);
}
}