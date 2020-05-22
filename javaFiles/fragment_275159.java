startLoading();
    ParseUser.logInInBackground(userName.getText().toString(), hashedPass, new LogInCallback() {
        public void done(ParseUser user, ParseException e) {
            if (user != null) {
                Log.d(Constants.TAG, "User Loged in.");
                ParseManager.sCurrentUser = user;
                stopLoading();
                finish();
            } else {
                stopLoading();
                invalidCreds();
            }
        }
    });