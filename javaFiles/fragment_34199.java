final GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(MyActivity.this);

 if (account != null) {
    gotoNextActivity();
 } else {
    signInButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            signIn();
        }
    });
 }