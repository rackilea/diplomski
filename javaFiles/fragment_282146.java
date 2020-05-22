@Override
protected void onResume() {
    super.onResume();

    if (checkLocationPermission()) {
        locationManager.requestLocationUpdates(provider, 400, 1, this);
    }
}