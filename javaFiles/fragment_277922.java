private void signIn() {
    try{
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    catch(Exception ex){
        //write to us your ex.getMessage();
    }
}