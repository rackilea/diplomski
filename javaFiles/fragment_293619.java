mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
    @Override
    public View getInfoWindow(Marker marker) {
        Log.e(TAG, "Info window requested for " + marker);
        mLastMarker = marker;
        return null; // Returning null will load the default InfoWindow
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }
});