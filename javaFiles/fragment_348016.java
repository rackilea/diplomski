@Override
public void onLocationChanged(Location location){
    latitude = String.valueOf(location.getLatitude());
    longitude = String.valueOf(location.getLongitude());
    Log.d("Latitude", "" + latitude);
    Log.d("Longitude", "" + longitude);
    updateUI();
    nextActivity();
}