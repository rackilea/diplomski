DataBaseHelper helper ;

EditText name, username,password1,password2;
String namestr,usernamestr,password1str,password2str;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_register);

    helper = new DataBaseHelper(this);
    name = (EditText) findViewById(R.id.et_name);
    username = (EditText) findViewById(R.id.et_username);
    password1 = (EditText) findViewById(R.id.et_password);
    password2 = (EditText) findViewById(R.id.et_password);

   namestr = name.getText().toString();
   usernamestr = username.getText().toString();
   password1str = password1.getText().toString();
   password2str = password2.getText().toString();
}