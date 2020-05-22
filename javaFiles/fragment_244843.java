public ArrayList<MarkerOptions> publishMarker(GoogleMap googleMap, int recourceMarker) {
    ArrayList<MarkerOptions> markerOption = new ArrayList<>();
    for (LatLng point : latlngs) {
        MarkerOptions markerOptions = new MarkerOptions().position(point);

  markerOptions.icon(BitmapDescriptorFactory.fromResource(recourceMarker));
        markerOption.add(markerOptions);
        googleMap.addMarker(markerOptions).setTag(point);
        googleMap.addMarker(markerOptions);
    }
    return markerOption;
}