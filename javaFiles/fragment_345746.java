public class GPSData {
    private static double latitude;
    /**
     * @return the latitude
     */
    public static double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public static void setLatitude(double l) {
        latitude = l;
    }

    private static double longitude;
    /**
     * @return the longitude
     */
    public static double getLongitude() {
        return longitude;
    }

    /**
     * @param d the longitude to set
     */
    public static void setLongitude(double d) {
        longitude = d;
    }
}


public static class MyLocationListener implements LocationListener {
    public void onLocationChanged(Location location) {
        setAccuracy(location.getAccuracy());
        setLongitude(location.getLongitude());
        setLatitude(location.getLatitude());
    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }
}