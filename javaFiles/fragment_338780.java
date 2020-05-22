mCurrentLocation=mLocationClient.getLastLocation();

      current_latitude=mCurrentLocation.getLatitude();
      current_longitude=mCurrentLocation.getLongitude();
      Toast.makeText(getApplicationContext(),current_latitude+"                 
         "+current_longitude,Toast.LENGTH_LONG).show();