@SuppressWarnings("MissingPermission")
    private void getLastLocation() {
     FusedLocationProviderClient   mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        mFusedLocationClient.getLastLocation()
                .addOnCompleteListener(new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        if (task.isSuccessful() && task.getResult() != null) {
                            mLastLocation = task.getResult();
                            double lat = mLastLocation.getLatitude();
                            double log = mLastLocation.getLongitude();
                            Log.d(TAG, "lat:"+lat+"::"+log);

                        } else {
                            Timber.w("getLastLocation:exception::" + task.getException());

                        }
                    }
                });
    }