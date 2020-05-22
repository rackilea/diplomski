public void onLocationChanged(Location location) {
    // TODO Auto-generated method stub
    lat = location.getLatitude();
    lon = location.getLongitude();

}
@JavascriptInterface
public double getLatitude() {
    Log.e("TAG",String.valueOf(lat));
    return lat;
}
@JavascriptInterface
public double getLongitude() {
    Log.e("TAG",String.valueOf(lon));
    return lon;
}