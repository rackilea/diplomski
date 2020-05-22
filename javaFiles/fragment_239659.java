int counter = 2;
Button login = null;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.loginview);

    final SharedPreferences prefs = this.getSharedPreferences("MyApp", Context.MODE_PRIVATE);
    login = (Button) findViewById(R.id.btnLogin);
    boolean enabled = prefs.getBoolean("LOGIN_ENABLED_KEY", true);
    login.setEnabled(enabled);
    if (!enabled) {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                login.setEnabled(true);
                prefs.edit().clear().apply();
                counter = 2;
            }
        }, 30000);
    }

    login.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             try {
                 EditText a = (EditText) findViewById(R.id.etUser);
                 EditText b = (EditText) findViewById(R.id.etPassword);
                 String user = a.getText().toString();
                 String pass = b.getText().toString();
                 if (user.equals("") || pass.equals("")) {
                     Toast passed = Toast.makeText(LoginControl.this, "Please input required fields.", Toast.LENGTH_LONG);
                     passed.show();
                 } else if (pass.equals("pass")) {
                     Toast passed = Toast.makeText(LoginControl.this, "Success!", Toast.LENGTH_LONG);
                     passed.show();
                     // Start HomeControl + finish()
                 } else if (counter == 0) {
                     // Disable button after 3 failed attempts
                     login.setEnabled(false);
                     prefs.edit().putBoolean("LOGIN_ENABLED_KEY", false).apply();
                     Toast alert = Toast.makeText(LoginControl.this, "Login Disabled for 5 mins", Toast.LENGTH_LONG);
                     alert.show();

                     final Handler handler = new Handler();
                     handler.postDelayed(new Runnable() {
                         @Override
                         public void run() {
                             login.setEnabled(true);
                             prefs.edit().clear().apply();
                             counter = 2;
                         }
                     }, 30000);
                 } else {
                     Toast passed = Toast.makeText(LoginControl.this, "Username or password don't match!", Toast.LENGTH_LONG);
                     counter--;
                     passed.show();
                 }
             } catch (Exception e) {
                 Toast passed = Toast.makeText(LoginControl.this, e.toString(), Toast.LENGTH_LONG);
                 passed.show();
             }
         }
    });
}