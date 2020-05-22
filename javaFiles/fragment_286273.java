if (mydb.getParentData(editTextEmailPhone.getText().toString(),editTextPassword.getText().toString()).size()>0) 
{
progressDialog.dismiss();
SharedPrefs.saveSharedSetting(this, "CaptainCode", "false");
Intent intent = new Intent(Login.this, Parent_Home.class);
Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
startActivity(intent);
finish();
}