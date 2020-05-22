CameraPosition cameraPosition = new CameraPosition.Builder()
.target(YourLatLng)      // Sets the center of the map to Mountain View
.zoom(17)                   // Sets the zoom
.bearing(90)                // Sets the orientation of the camera to east
.tilt(30)                   // Sets the tilt of the camera to 30 degrees
.build();                   // Creates a CameraPosition from the builder

map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));