private Location getLocation() {
    LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    if (manager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
        return manager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
    } else if (manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
        return manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
    }
    return null;
}