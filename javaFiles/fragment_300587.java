List<MarkerOptions> markers = new ArrayList<MarkerOptions>();

MarkerOptions markerOptions = new MarkerOptions()
    .position(new LatLng(lat, lon))
    .title(marker_title);
Marker m = mMap.addMarker(markerOptions);
markers.add(markerOptions);