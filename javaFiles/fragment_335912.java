@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.login);

    btnLogin = (Button) findViewById(R.id.btnLogin);
    btnLogin.setOnClickListener(
      new OnClickListenerLogin(
          (EditText) findViewById(R.id.txtUsername), 
          (EditText) findViewById(R.id.txtPassword));
}