// Result returned from launching the Intent from
//   GoogleSignInApi.getSignInIntent(...);
if (requestCode == RC_SIGN_IN) {
    GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
    handleSignInResult(result);
} else {
    ParseFacebookUtils.onActivityResult(requestCode, resultCode, data);
}