...
locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 2000, 0, this);
...

public void onLocationChanged(Location arg0) {
    if (arg0 != null){
        double longitude = arg0.getLongitude();
        double latitude = arg0.getLatitude();

        ...
    }
}