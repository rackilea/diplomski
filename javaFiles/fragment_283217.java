public  void displayCurrentLocation(){
    CameraPosition cameraPosition = new CameraPosition.Builder().
            target(new LatLng(mLocation.getLatitude(), mLocation.getLongitude())).
            tilt(60).
            zoom(15).
            bearing(0).
            build();
       mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        loadLocation="done";
}