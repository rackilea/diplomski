LocationListener locationListener = new LocationListener() {
    public void onLocationChanged(Location location) {
       //here you get locations from both providers
    }

    public void onProviderDisabled(String provider) {
    }

    public void onProviderEnabled(String provider) {
    }

    public void onStatusChanged(String provider, int status, Bundle extras) {
    }
};