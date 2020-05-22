public Location getLocation(){
    try{
        locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);
        isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        if(!isNetworkEnabled && !isGPSEnabled){
             Log.e("GPSTracker", "!isNetworkEnabled && !isGPSEnabled");
             Log.e("GPSTracker", "is network location enabled: " + isNetworkEnabled );
             Log.e("GPSTracker", "is GPS location enabled: " + isGPSEnabled);
        }else{
            this.canGetLocation = true;

            if(isNetworkEnabled){
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MinTimeUpdate, MinDistanceChangeUpdate, this);

                if(locationManager != null){
                    location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

                    if(location != null){
                        latitude = location.getLatitude();
                        longitude = location.getLongitude();
                    }
                }
            }


            if(isGPSEnabled){
                if(location == null){
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MinTimeUpdate, MinDistanceChangeUpdate, this);

                    if(locationManager != null){
                        location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

                        if(location != null){
                            latitude = location.getLatitude();
                            longitude = location.getLongitude();
                        }
                    }
                }

            }
        }

    }catch(Exception e){
        Log.e("GPSTracker", "error getting location", e);
        e.printStackTrace();
    }

    return location;
}