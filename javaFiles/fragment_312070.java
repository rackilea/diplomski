public void register(final View v){
    if(mUsernameField.getText().length() == 0 || mPasswordField.getText().length() == 0)
        return;

    v.setEnabled(false);
    ParseUser user = new ParseUser();
    user.setUsername(mUsernameField.getText().toString());
    user.setPassword(mPasswordField.getText().toString());
    //mErrorField.setText("");

    user.signUpInBackground(new SignUpCallback() {
        @Override
        public void done(ParseException e) {
            if (e == null) {
                Intent intent = new Intent(RegisterActivity.this, LoggedIn.class);
                startActivity(intent);
                finish();
            } else {
                // Sign up didn't succeed. Look at the ParseException
                // to figure out what went wrong
                switch(e.getCode()){
                    case ParseException.USERNAME_TAKEN:
                        mErrorField.setText("Sorry, this username has already been taken.");
                        break;
                    case ParseException.USERNAME_MISSING:
                        mErrorField.setText("Sorry, you must supply a username to register.");
                        break;
                    case ParseException.PASSWORD_MISSING:
                        mErrorField.setText("Sorry, you must supply a password to register.");
                        break;
                    default:
                        mErrorField.setText(e.getLocalizedMessage());
                }
                v.setEnabled(true);
            }
        }
    });
}