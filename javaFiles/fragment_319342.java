HashMap<Marker, JSONObject> stopsMarkersInfo = new HashMap<>(); // created the HashMap
JSONArray stops = new File().getStops(lineId);
for (int i = 0; i < stops.length(); i++) {
    BitmapDescriptor stopMarkerIcon = new File().getStopMarkerIcon(color, Integer.parseInt(stops.getJSONObject(i).getString("sequence")));
    LatLng coordinate = new LatLng(Double.parseDouble(stops.getJSONObject(i).getString("lat")), Double.parseDouble(stops.getJSONObject(i).getString("lng")));
    MarkerOptions markerOptions = new MarkerOptions().icon(stopMarkerIcon).position(coordinate).anchor(.5f, .5f);
    Marker marker = googleMap.addMarker(markerOptions);
    stopsMarkersInfo.put(marker, stops.getJSONObject(i)); // added each marker and 
                                                          // his information to the HashMap
}
googleMap.setInfoWindowAdapter(new StopsInfoWindow(stopsMarkersInfo)); // passed the HashMap