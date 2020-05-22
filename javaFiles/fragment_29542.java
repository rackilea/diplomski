public void LoginCallback(final boolean loginSuccess, final boolean isActivated) {
    final Context context = this;
    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            if (loginSuccess && isActivated) {
                loggingIn.hide();
                loggingIn = null;
                finish();
            } else if (loginSuccess == false) {
                Toast.makeText(context, "Login failed! User/Password wrong", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Login failed! Account not activated", Toast.LENGTH_SHORT).show();
            }
        }
    });

}