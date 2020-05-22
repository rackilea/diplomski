String email = ed1.getText().toString();
String password = ed2.getText().toString();
SharedPreferences.Editor editor = sharedpreferences.edit();

editor.putString(email, password);
editor.commit();