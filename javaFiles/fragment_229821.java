mGoogleApiClient = new GoogleApiClient.Builder(this)
        .enableAutoManage(this, new GoogleApiClient.OnConnectionFailedListener() {
            @Override
            public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                Log.e("Failed", "failed" + connectionResult.getErrorMessage());
            }
        })
        .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
        .build();