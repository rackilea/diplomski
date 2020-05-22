public void insert() {
    User user = new User (
        userName.getText().toString(),
        userPhone.getText().toString());
    dbHandler.addUser(user);
    Toast.makeText(getBaseContext(), "Prijavljeni ste!", Toast.LENGTH_SHORT).show();

//set activity_executed inside insert() method.
SharedPreferences pref = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);
SharedPreferences.Editor edt = pref.edit();
edt.putBoolean("activity_executed", true);
edt.commit();

}