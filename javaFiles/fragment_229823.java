`private void handleSignInResult(GoogleSignInResult result) {
        Log.e("handleSignIn", "handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {
            // Signed in successfully, show authenticated UI.
            final GoogleSignInAccount acct = result.getSignInAccount();
            if (acct != null) {
                ParseQuery<ParseObject> query = ParseQuery.getQuery("_User");
                query.setLimit(10000);
                query.whereEqualTo("email", acct.getEmail());
                query.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> objects, ParseException e) {
                        if (e == null) {
                            if (objects.size() == 0) {
                                saveNewUserGoogle(acct);
                            } else {
                                loginGoogleUser(objects.get(0), acct);
                            }
                        } else {
                            saveNewUserGoogle(acct);
                        }
                    }
                });
            }
        } else {
            Log.e("failed", "failed to sign in");
            // Signed out, show unauthenticated UI.
        }
    }`