private void handleNewLocation(Location location) {
    Log.d(TAG, location.toString());
    currentLatitude = location.getLatitude(); //update member variable
    currentLongitude = location.getLongitude(); //update member variable
    loc = "Latitude: " + Double.toString(currentLatitude) + ", Longitude: " + Double.toString(currentLongitude);
    Log.v(TAG, loc);
}