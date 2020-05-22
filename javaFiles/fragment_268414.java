public class MainActivity extends Activity {

    ... // variables and such

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextShowLocation = (EditText) findViewById(R.id.editTextShowLocation);

        locManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        setupLocationUpdates();
    }


    private void setupLocationUpdates() {
        try {
            gps_enabled = locManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception ex) { /* tsk tsk, empty catch block */ }
        try {
            network_enabled = locManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception ex) { /* tsk tsk, empty catch block */ }

        // don't start listeners if no provider is enabled
        if (!gps_enabled && !network_enabled) {
            Log.d(TAG, "Not Enabled!"); //to enable it for user.
        }

        if (gps_enabled) {
            locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locListener);
        }
        if (network_enabled) {
            locManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locListener);
        }
    }

    class MyLocationListener implements LocationListener {
        @Override
        public void onLocationChanged(Location location) {
            // do your stuff
        }

        // all the other required callback methods
    }
}