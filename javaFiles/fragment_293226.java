@Override
        public void onConnected(Bundle bundle) {
            Log.d("MYTAG", "GOOGLE API CONNECTED!");
            mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                    mGoogleApiClient);
            if (mLastLocation == null) {
               mLocationRequest = new LocationRequest();
               mLocationRequest.setInterval(minTime);
               mLocationRequest.setFastestInterval(fastestTime);
                                 mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
              mLocationRequest.setSmallestDisplacement(distanceThreshold);
              LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
            }

        }