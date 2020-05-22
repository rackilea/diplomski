public class GPS_Service extends Service {
    private LocationListener listener;
    private LocationManager locationManager;
    public Integer gpsupdatedelay = 10000; //NOT static!

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    //Added:
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int newGpsUpdateDelay = intent.getIntExtra("new_gps_update_delay", -99);
        if (newGpsUpdateDelay != -99 && locationManager != null) {
            gpsupdatedelay = newGpsUpdateDelay;
            //noinspection MissingPermission
            locationManager.removeUpdates(listener);
            //noinspection MissingPermission
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,gpsupdatedelay,0,listener);
        }
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        Log.e("GPS","onCreate");
        listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Intent i = new Intent("location_update");
                //i.putExtra("coordinates",location.getLongitude()+" "+location.getLatitude());

                i.putExtra("coordinate1",location.getLatitude());
                i.putExtra("coordinate2",location.getLongitude());
                Log.e("GPS","sendBroadcast");
                sendBroadcast(i);
            }
            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {
            }
            @Override
            public void onProviderEnabled(String s) {
            }
            @Override
            public void onProviderDisabled(String s) {
                Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        };
        locationManager = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        //noinspection MissingPermission
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,gpsupdatedelay,0,listener);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if(locationManager != null){
            //noinspection MissingPermission
            locationManager.removeUpdates(listener);
        }
    }
}