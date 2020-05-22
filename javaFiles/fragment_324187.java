private void initMyLocationNewOverlay() {
        GpsMyLocationProvider provider = new GpsMyLocationProvider(context);
        provider.addLocationSource(LocationManager.NETWORK_PROVIDER);
        myLocationNewOverlay = new MyLocationNewOverlay(provider, mapView);
        myLocationNewOverlay.enableMyLocation();
        mapView.getOverlays().add(myLocationNewOverlay);
    }