private class GPSLocationListener implements LocationListener {
    MapOverlay mOverlay;

    public GPSLocationListener() {

    }

   @Override
   public void onLocationChanged(Location location) {
    if (location != null) {
        GeoPoint point = new GeoPoint(
                (int) (location.getLatitude() * 1E6), 
                (int) (location.getLongitude() * 1E6));

        findUsersInCurrentRadius(4,location.getLatitude(),location.getLongitude());

        mapController.animateTo(point);
        mapController.setZoom(15);

        if (mOverlay == null) {
            // Add this marker to the list of overlays always.
            // This stuff never changes so there is no need to do this logic
            // Every 30 secs. Loading images is **Expensive**
            mOverlay = mMapOverlay = new MapOverlay(this,android.R.drawable.star_on);
            List<Overlay> listOfOverlays = mapView.getOverlays();
            listOfOverlays.add(mMapOverlay);
        }
        // **See, no need to make a new Object here**
        mOverlay.setPointToDraw(point);

        // This can probably be done at another time.
        // String address = ConvertPointToLocation(point);
        // Toast.makeText(getBaseContext(), address, Toast.LENGTH_SHORT).show();

        mapView.invalidate();
    }