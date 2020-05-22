mGoogleApiClient = new GoogleApiClient.Builder(this,this,this)
    .addApi(Plus.API)
    .addScope(Plus.SCOPE_PLUS_LOGIN)
    .addConnectionCallbacks(this)
    .addOnConnectionFailedListener(this)
    .build();