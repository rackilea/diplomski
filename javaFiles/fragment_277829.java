user.signUpInBackground(new SignUpCallback() {
  @Override
  public void done(com.parse.ParseException e) {
    if (e == null) {
      // Hooray! Let them use the app now.
    } else {
      // Sign up didn't succeed. Look at the ParseException
      // to figure out what went wrong
    }
  }
});