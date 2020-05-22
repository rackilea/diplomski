LocationManager locationManager = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
    onLocationChanged(Location location) {
         // put code in here to respond to a change in location
    }
    onProviderDisabled(String provider) {
         // put code in here to respond to GPS being disabled
    }
    onProviderEnabled(String provider) {
        // put code in here to respond to GPS being enabled
    }
    onStatusChanged(String provider, int status, Bundle extras) {
        // put code in here to respond to change in GPS status (e.g. GPS becomes unavailable)
    }
});