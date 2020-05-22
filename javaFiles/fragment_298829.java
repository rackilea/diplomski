// setup input fields
user = (EditText) findViewById(R.id.username);

SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
String userName = sp.getString("user", "");
user.setText(userName);

pass = (EditText) findViewById(R.id.password);