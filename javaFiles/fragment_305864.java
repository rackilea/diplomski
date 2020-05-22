public void login(View view) {
    email = (EditText) findViewById(R.id.email);
    password = (EditText) findViewById(R.id.password);
    error = (TextView) findViewById(R.id.error);

    ParseUser.logInInBackground(email.getText().toString(), password.getText().toString(), new LogInCallback() {
        @Override
        public void done(ParseUser user, ParseException e) {
            if (user != null) {
                // Success
            } else {
                error.setText("Error logging in. Please try again later.");
            }
        }
    });
}