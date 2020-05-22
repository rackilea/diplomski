public void onLocationChanged(Location location) {

    location.getLatitude();
    location.getLongitude();

    String myLocation = location.getLatitude() + " " + location.getLongitude();

    listener.onFooChange(myLocation);