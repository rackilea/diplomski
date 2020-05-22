try {
                // Get the location manager
    locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
                    Criteria criteria = new Criteria();
                    bestProvider = locationManager.getBestProvider(criteria, false);
                    Location location = locationManager
                            .getLastKnownLocation(bestProvider);
                    double lat = location.getLatitude();
                    double lon = location.getLongitude();
                    Geocoder gc = new Geocoder(this);
                    List<Address> lstAdd = gc.getFromLocation(lat, lon, 1);
                    Address ad = lstAdd.get(0);
                    String str = ad.getAddressLine(0);
                Toast tst = Toast.makeText(this, "Your current location is " + str,
                        Toast.LENGTH_LONG);
                tst.show();
} catch (Exception e) {
                Toast tst = Toast.makeText(this,"Please check your gps settings",
                        Toast.LENGTH_LONG);
                tst.show();
}