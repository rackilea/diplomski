@Override
public void onLocationChanged(Location location) {
    this.location = location;
    getLatitude();
    getLongitude();
}