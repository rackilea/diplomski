@Override
protected void onResume() {
    super.onResume();
    if (ContextCompat.checkSelfPermission(this,
            Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED) {

        locationManager.requestLocationUpdates(provider, 400, 1, this);
    }
}

@Override
protected void onPause() {
    super.onPause();
    if (ContextCompat.checkSelfPermission(this,
            Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED) {

        locationManager.removeUpdates(this);
    }
}