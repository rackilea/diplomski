if (typedUsername.getText().toString().equals("username") && 
        typedPassword.getText().toString().equals("password")) {
    Intent intent = new Intent(this, LoggedIn.class);

    startActivity(intent);
}
else {
    Toast.makeText(getApplicationContext(), "Wrong Username or Password", Toast.LENGTH_SHORT).show();
}