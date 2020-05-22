protected void onPostExecute(final String success) {
     //            super.onPostExecute(success);
    mAuthTask = null;
    showProgress(false);

    if (success.equals("true")) {

        finish();
        Toast.makeText(getApplicationContext(),"login success",Toast.LENGTH_SHORT).show();
        Intent myIntent = new Intent(LoginPage.this,Authorities.class);
        LoginPage.this.startActivity(myIntent);
    } else {
        mPasswordView.setError(getString(R.string.error_incorrect_password));
        mPasswordView.requestFocus();
    }
}