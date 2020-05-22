btnlogin.setOnClickListener(new View.OnClickListener() {
@Override
 public void onClick(View v) {
 userid = edtuserid.getText().toString();
 password = edtpass.getText().toString();

SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE); 
Editor editor = pref.edit();
editor.putString("name_from_main", userid );  // Saving string

// Save the changes in SharedPreferences
editor.commit(); // commit changes


}
});