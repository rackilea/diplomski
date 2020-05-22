private EditText etUsername, etPassword;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    etUsername = (EditText) findViewById(R.id.etUsername);
    etPassword = (EditText) findViewById(R.id.etPassword);

    String username = SharedPreferenceUtils.getUsername(this);
    String password = SharedPreferenceUtils.getPassword(this);
    etUsername.setText(username);
    etPassword.setText(password);
}