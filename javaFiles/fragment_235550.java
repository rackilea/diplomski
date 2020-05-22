public class Saver extends Activity {

    Button b;

    Location newLocation = null;//add thiss

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saver);
        b = (Button) findViewById(R.id.button1);


             //set this listener
        b.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (newLocation != null) {

                    String Text = "Current location is: " + "Latitud = "
                            + newLocation.getLatitude() + "Longitud = "
                            + newLocation.getLongitude();
                    Toast.makeText(getApplicationContext(), Text,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        // We use LocationManager class to obtain GPS locations
        LocationManager mlocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        LocationListener mlocListener = new MyLocationListener();

        mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,
                mlocListener);
    }

    public class MyLocationListener implements LocationListener {

        public void onLocationChanged(Location loc) {

               //save the new location
               newLocation = loc;

        }

        public void onProviderDisabled(String provider) {
            Toast.makeText(getApplicationContext(), "Gps Disabled",
                    Toast.LENGTH_SHORT).show();
        }

        public void onProviderEnabled(String provider) {
            Toast.makeText(getApplicationContext(), "Gps Enabled",
                    Toast.LENGTH_SHORT).show();
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
        }
    }
}