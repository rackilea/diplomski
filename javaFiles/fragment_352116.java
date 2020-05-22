@Override
protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_log);

     uname = (EditText) findViewById(R.id.et_username);
     unstr = uname.getText().toString();
     pass = (EditText) findViewById(R.id.et_password);
     passstr = pass.getText().toString();

}