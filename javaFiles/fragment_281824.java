public class Login extends ActionBarActivity implements View.OnClickListener {
Button bLogin;
TextView registerLink;
EditText etUsername, etPassword;
String username, password;

UserLocalStore userLocalStore;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    bLogin = (Button) findViewById(R.id.bLogin);
    etUsername = (EditText) findViewById(R.id.etUsername);
    etPassword = (EditText) findViewById(R.id.etPassword);
    registerLink = (TextView) findViewById(R.id.tvRegisterLink);