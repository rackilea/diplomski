user.getIdToken(true).addOnSuccessListener(new OnSuccessListener<GetTokenResult>() {
  @Override
  public void onSuccess(GetTokenResult result) {
    String idToken = result.getToken();
    //Do whatever
    Log.d(TAG, "GetTokenResult result = " + idToken);
  }
});