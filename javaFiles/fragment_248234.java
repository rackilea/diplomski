googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
    // TODO: Consider calling
    //    ActivityCompat#requestPermissions
    // here to request the missing permissions, and then overriding
    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
    //                                          int[] grantResults)
    // to handle the case where the user grants the permission. See the documentation
    // for ActivityCompat#requestPermissions for more details.
    return;
}
googleMap.setMyLocationEnabled(true);
googleMap.getUiSettings().setZoomControlsEnabled(false);
googleMap.getUiSettings().setMyLocationButtonEnabled(true);
googleMap.getUiSettings().setCompassEnabled(true);
googleMap.getUiSettings().setRotateGesturesEnabled(true);
googleMap.getUiSettings().setZoomGesturesEnabled(true);

if (locationManager == null) {
    locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
}
if (locationManager.getAllProviders().contains(LocationManager.GPS_PROVIDER)) {
    isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    isNetworkProviderEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    if (isGPSEnabled) {
        location = getLastLocationByProvider(locationManager, LocationManager.GPS_PROVIDER, getApplicationContext());
    } else if (isNetworkProviderEnabled) {
        location = getLastLocationByProvider(locationManager, LocationManager.NETWORK_PROVIDER, getApplicationContext());
    }
    if (location != null) {
        latitude = location.getLatitude();
        longitude = location.getLongitude();
    } else {
        if (isNetworkProviderEnabled) {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 100000, 1, this);
            provider_info = LocationManager.NETWORK_PROVIDER;
        } else if (isGPSEnabled) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100000, 1, this);
            provider_info = LocationManager.GPS_PROVIDER;
        } else {

            alertDialog = Util.showOkDialog(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Env.currentActivity != null) {
                        if (Env.currentActivity instanceof LocationActivity) {
                            try {
                                gotoSettings();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                    }
                    if (alertDialog != null) {
                        alertDialog.dismiss();
                        alertDialog = null;
                    }

                }
            }, this.getResources().getString(R.string.location_service_validation));

        }

        location = locationManager.getLastKnownLocation(provider_info);
        if (location != null) {
            latitude = location.getLatitude();
            longitude = location.getLongitude();
        }
    }

    MarkerOptions marker = new MarkerOptions().position(
            new LatLng(latitude, longitude))
            .title(getFullAddressLine(this));
    marker.icon(BitmapDescriptorFactory
            .defaultMarker(BitmapDescriptorFactory.HUE_GREEN));

    googleMap.addMarker(marker);
    CameraPosition cameraPosition = new CameraPosition.Builder()
            .target(new LatLng(latitude,
                    longitude)).zoom(15).build();
    googleMap.animateCamera(CameraUpdateFactory
            .newCameraPosition(cameraPosition));
}