private void login(){
    String username = etUsername.getText().toString();
    String pass = etPass.getText().toString();

    if(db.getUser(username,null,pass)){
        session.setLoggedin(true);
        //startActivity(new Intent(LoginActivity.this, HomeActivity.class)); <<<<<<<<< OLD CODE
        Intent intent = new Intent(LoginActivity.this,HomeActivity.class); //<<<<<<<<<< NEW CODE
        intent.putExtra(INTENTEXTRAKEY_LOGGEDINUSERNAME,username); //<<<<<<<<<< NEW CODE
        startActivity(intent); //<<<<<<<<<< NEW CODE
        finish();
    }else{
        Toast.makeText(getApplicationContext(), "Wrong username/password",Toast.LENGTH_SHORT).show();
    }
}