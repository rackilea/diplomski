@Override
public void onMapReady(GoogleMap googleMap) {
    Log.d(TAG, "onMapReady()");
    mGoogleMap = googleMap;
    /*
    * Adding map control buttons
    * */
    mUiSettings = mGoogleMap.getUiSettings();
    mUiSettings.setZoomControlsEnabled(true);

    if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED) {
        Log.d(TAG, "PERMISSION_GRANTED");

        /*
        * Allow application to get user location
        * */
        mGoogleMap.setMyLocationEnabled(true);



    } else {
        Log.d(TAG, "PERMISSION_NOT_GRANTED");
        Toast.makeText(getActivity(), "Permissions to get the location are not granted. Please setup the permissions.", Toast.LENGTH_LONG).show();
    }
}