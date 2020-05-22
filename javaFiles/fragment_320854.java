LocationManager locationManager = (LocationManager)
                     getSystemService(Context.LOCATION_SERVICE);
    Criteria criteria = new Criteria();
    Location location = locationManager.getLastKnownLocation(locationManager
   .getBestProvider(criteria, false));
    double latitude = location.getLatitude();
    double longitude = location.getLongitude();