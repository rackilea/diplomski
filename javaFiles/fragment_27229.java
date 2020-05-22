String email = ed1.getText().toString();
String password = ed2.getText().toString();

password += email;

SharedPreferences.Editor editor = sharedpreferences.edit();
editor.putString(this.email,email);
editor.putString(this.password,password);
editor.commit();