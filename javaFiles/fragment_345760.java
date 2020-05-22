if (!polyLineList.isEmpty()) {
    // Adjusting Bounds
    LatLngBounds.Builder builder = new LatLngBounds.Builder();
    for (LatLng latLng:polyLineList) {
      builder = builder.include(latLng);
    }
    LatLngBounds bounds = builder.build();
    CameraUpdate mCameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, 2);
    mMap.animateCamera(mCameraUpdate);
}