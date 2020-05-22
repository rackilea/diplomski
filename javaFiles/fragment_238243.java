List<Marker> mMarkers = new Arraylist<Marker>();

for (LatLng latLng : latLngList) {
        Marker marker = mMap.addMarker(new MarkerOptions()
                    .position(latLng)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMarkers.add(marker);
}