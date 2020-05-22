@Override
public void onLocationChanged(Location location) {
    if(location!=null)
    {
update(location.getLatitude(), location.getLongitude());
    }
}