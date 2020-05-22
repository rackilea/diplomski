mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
    @Override
    public void onMapClick(LatLng latLng) {
        if (mLastMarker != null) {
            mLastMarker = null;
            // Stop task
        }
    }
});