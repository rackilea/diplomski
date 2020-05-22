private GoogleApiClient buildGoogleApiClient() {
    return new GoogleApiClient.Builder(this)
            .addConnectionCallbacks(this)
            .addOnConnectionFailedListener(this)
            .addApi(Plus.API, null)
            .addScope(Plus.SCOPE_PLUS_LOGIN)
            .build();
}