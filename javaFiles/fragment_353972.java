@Override
    public void onConnected(Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(this, 
           Manifest.permission.ACCESS_FINE_LOCATION) != 
           PackageManager.PERMISSION_GRANTED && 
           ActivityCompat.checkSelfPermission(this, 
           Manifest.permission.ACCESS_COARSE_LOCATION) != 
           PackageManager.PERMISSION_GRANTED) {
               System.out.println("Problem with rights");
        } else {

           Location lastLocation = LocationServices.FusedLocationApi
                                       .getLastLocation(mGoogleApiClient);

           if (lastLocation != null) {
            //you have a location. use that here. no need to request for location 
            // updates
            mGoogleApiClient.disconnect();
           } else {
            //you have to request for location
             mLocationRequest = LocationRequest.create();
             mLocationRequest.setInterval(2000);
             mLocationRequest.setFastestInterval(1000);
             mLocationRequest.setSmallestDisplacement(50);
             mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
             LocationServices.FusedLocationApi
               .requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);

           }

        }
    }