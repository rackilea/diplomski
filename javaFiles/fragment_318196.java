LatLngBounds.Builder builder = new LatLngBounds.Builder();
// Add your locations to bounds using builder.include, maybe in a loop
LatLngBounds bounds = builder.build();
//Then construct a cameraUpdate
CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, 0);
//Then move the camera
map.animateCamera(cameraUpdate);