class UpdateGeoLocation {
    LocationManager locationManager;
    String provider;
    double lat, lng;
    Location location;
    Location returnlocation;
    Context context;

    public static String locationdetails = null;

    public UpdateGeoLocation(Context context) {
        this.context = context;     
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        locationManager = (LocationManager) context
                .getSystemService(Context.LOCATION_SERVICE);
        provider = locationManager.getBestProvider(criteria, true);
        location = locationManager.getLastKnownLocation(provider);
        returnlocation = locationManager.getLastKnownLocation(provider);
    }

    public Location getLocation(Location location) {

        if (location != null) {
            Log.d("one", "IF getLocation :: " + location);
            returnlocation.setLatitude(location.getLatitude());
            returnlocation.setLongitude(location.getLongitude());

        } else {
            try {
                listenForLocation(provider);
            } catch (NullPointerException nullPointerException) {
                nullPointerException.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return returnlocation;

    }

    private void listenForLocation(String providerName) {
        locationManager.requestLocationUpdates(providerName, 0, 0,
                locationListener);
        if (location != null) {
            location.getLatitude();
            location.getLongitude();
            getLocation(location);
        } else {
            // Toast.makeText(context, "location null",
            // Toast.LENGTH_SHORT).show();
        }
    }

    private final LocationListener locationListener = new LocationListener() {
        public void onLocationChanged(Location location) {
            returnlocation.setLatitude(location.getLatitude());
            returnlocation.setLongitude(location.getLongitude());
        }

        public void onProviderDisabled(String provider) {

        }

        public void onProviderEnabled(String provider) {
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
        }
    };

}


Following is the Activity where I used above class to get LatLong :

Location location = null;

OnCreate() :

try {
    Looper.prepare();
    if (null != (location = requestForLocation())) {
        if (null != location) {
            Log.d("one", "Location :: " + location.getLatitude());
            Log.d("one", "Location  LATLONG :: " + location.getLongitude());

                        //Use intent or bundle here to send LatLong to other activities..


        } else {
            Log.d("one", "Location not found:: ");

        }
    }
} catch (Exception ex) {
    ex.printStackTrace();
} 


private Location requestForLocation() {
    return new UpdateGeoLocation(MonsterLoginActivity.this)
    .getLocation(null);
}