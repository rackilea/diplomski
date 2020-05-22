@Override
public boolean onMarkerClick(Marker marker) {
    String title = marker.getTitle();
    LatLng position = marker.getPosition();

    return true;
}