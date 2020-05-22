private void setupLocation() {

    LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

    LocationListener locationListener = new LocationListener() {
        public void onLocationChanged(final Location location) {
            runOnUiThread(new Runnable() {
                public void run() {
                    mLocation = location;
                    //Log.d(TAG, "Latitude: " + location.getLatitude() + " - Longitude: " + location.getLongitude());

                    saveLocation();
                }
            });   
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {}

        public void onProviderEnabled(String provider) {}

        public void onProviderDisabled(String provider) {}
    };

            //Can set to GPS or network, whichever is available
    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
}