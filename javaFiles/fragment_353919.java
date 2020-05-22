GPSTrack gpsTrack = new GPSTrack(context);
if(gpsTrack.canGetLocation()){
    Location location = gpstracker.getLocation();
    double lat = location.getLatitude();
    double lang = location.getLongitude();
}