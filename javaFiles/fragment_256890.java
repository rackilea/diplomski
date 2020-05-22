private void _getLocation() {

    // Get the location manager
    LocationManager locationManager = (LocationManager) 
            getSystemService(LOCATION_SERVICE);
    Criteria criteria = new Criteria();
    String bestProvider = locationManager.getBestProvider(criteria, false);
    Double longitude, latitude;
    Location location = locationManager.getLastKnownLocation(bestProvider);

    try {
        latitude = location.getLatitude();
        longitude = location.getLongitude();
    } catch (NullPointerException e) {
        latitude = -1.0;
        longitude = -1.0;
    }
}