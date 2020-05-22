@Override
public boolean onMarkerClick(Marker marker) {
    //change marker colour to yellow
    marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
    for(Marker otherMarker : mMarkers) {
        otherMarker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
    }

    return false;
}