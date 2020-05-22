map.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
    @Override
    public void onMarkerDragStart(Marker marker) {
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 15));
        map.getUiSettings().setAllGesturesEnabled(false);
    }

    @Override
    public void onMarkerDrag(Marker marker) {}

    @Override
    public void onMarkerDragEnd(Marker marker) {
        map.getUiSettings().setAllGesturesEnabled(true);
    }
});