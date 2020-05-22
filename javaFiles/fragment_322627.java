/**
 * This method is get called when user tap on a marker
 */
private OnMarkerClickListener mMarkerClickListener = new OnMarkerClickListener() {

    @Override
    public boolean onMarkerClick(Marker marker) {
        Toast.makeText(context, "clicked: " + markersAndObjects.get(marker.getId()), Toast.LENGTH_SHORT).show();
        return false;
    }
};

// Don't forget to set the listener 

googleMap.setOnMarkerClickListener(mMarkerClickListener);

// markersAndObjects below is a hashmap where 

Marker marker = googleMap.addMarker(markerOptions);
markersAndObjects.put(marker.getId(), (YOUR DATA));