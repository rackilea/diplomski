public void load() {
    final SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
    SharedPreferences.Editor editor = pref.edit();

    String value=(pref.getString("Name", ""));
    String value2=(pref.getString("Password", ""));

    if (value.equals(Lname.getText().toString()) & value2.equals(Password.getText().toString())){
        LoginSuccess();
    } else{
        Toast.makeText(this, "Last Name or Password Incorrect or Does not Exist!", Toast.LENGTH_SHORT).show();
    }
}