public class loginactivity extends AppCompatActivity {

    Button loginButton;
    Button signUpButton;
    EditText usernameField;
    EditText passwordField;

    String username;
    String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);

        loginButton = (Button) findViewById(R.id.btlogin);
        signUpButton = (Button) findViewById(R.id.btsignup);
        usernameField = (EditText) findViewById(R.id.tusername);
        passwordField = (EditText) findViewById(R.id.tpassword);

        //rest of your code
        ..............
        }