public double distanceBetween(Context mContext)
{
    locationManager = (LocationManager) mContext
        .getSystemService(Context.LOCATION_SERVICE);
    dining1 = new Location("");
    dining1.setLatitude(37.226500);
    dining1.setLongitude(-80.419179);
    dining2 = new Location("");
    dining2.setLatitude(37.229219);
    dining2.setLongitude(-80.418310);
    return dining1.distanceTo(dining2);
}