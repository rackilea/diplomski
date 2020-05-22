@Override
public void onMapReady(GoogleMap googleMap) {
    mGoogleMap = googleMap;

    // Add a marker in Sydney, Australia, and move the camera.
    LatLng sydney = new LatLng(-34, 151);
    mGoogleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
    mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
}