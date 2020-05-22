@Override
protected void onStart() {
    super.onStart();
    if (mGoogleApiClient != null)
        mGoogleApiClient.connect();
}

@Override
protected void onStop() {
    super.onStop();
    if (mGoogleApiClient != null)
        mGoogleApiClient.disconnect();

}