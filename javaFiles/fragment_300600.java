class GenerateMarkerTask extends AsyncTask(List<Event>, Integer, List<Marker>) {

protected List<Marker> doInBackground(List<Event>... events) {
    List<Marker> markers = new ArrayList();
    for (Event event: listOfEvents) {
        LatLng latLng = event.getCoordinates();
        LatLngBounds bounds = mMap.getProjection().getVisibleRegion().latLngBounds;
        boolean isMarkerOnMap = markerksOnMap.contains(latLng);
            if bounds.contains(latLng) {
                if (!isMarkerOnMap) {
                    // add marker
                    markers.add(latLng);
                }
            }
    }

}

protected void onPostExecute(List<Marker> result) {
    markerksOnMap.clear();
    for (Marker marker: result) {
        markersOnMap.add(result);
    }

 }

}