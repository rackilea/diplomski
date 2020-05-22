public class MyReceiver extends Service implements LocationListener {

    private LocationManager locationManager;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        onHandleIntent(intent);
        return START_NOT_STICKY;
    }

    protected void onHandleIntent(Intent intent) {
        Log.i("DebugMe", "Intent Fired");
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
    }

    public void onLocationChanged(Location location) {
        String lat = String.valueOf(location.getLatitude());
        String lon = String.valueOf(location.getLongitude());
        Log.i("DebugMe", lat + " " + lon);
        locationManager.removeUpdates(this);
        // this is where you stop the service
        stopSelf();
    }

    public void onProviderDisabled(String provider) {
        Log.d("DebugMe ", "Disabled");
    }

    public void onProviderEnabled(String provider) {
        Log.d("DebugMe", "Enabled");
    }

    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.d("DebugMe", "Status");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}