private void updateUserLocation(){
    if ( Build.VERSION.SDK_INT >= 23 &&
            ContextCompat.checkSelfPermission( getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION )
                    != PackageManager.PERMISSION_GRANTED &&
            ContextCompat.checkSelfPermission( getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
        return;
    }

    locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);

    if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)){

        LocationListener listener = new GpsListener();

        Looper.prepare();
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, listener);
        Looper.loop();

    }else {
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {

            LocationListener listener = new GpsListener();

            Looper.prepare();
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
            Looper.loop();
        }
    }
}