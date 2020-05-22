@Override
public void onLocationChanged(Location location) {

    //location changed, update current location
    handleNewLocation(location);
    Log.v(TAG, "new location");

}