public class MainActivity extends ActionBarActivity implements LocationListener {

double lat = 0;
double lon = 0;

LocationListener asd = new MyLocationListener();
Location loc;
LocationManager locManager;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

    Button button = (Button) findViewById(R.id.toggleButton1);
    button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {

            _getLocation();


        }
    });
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();
    if (id == R.id.action_settings) {
        return true;
    }
    return super.onOptionsItemSelected(item);
}


private void _getLocation() 
{
    try 
    {   
        this.loc = null;
        locManager.requestSingleUpdate(LocationManager.NETWORK_PROVIDER, this, null);

        // Waiting for the update
        while(loc == null);

        Toast.makeText(this,  "Long: " + loc.getLongitude() + "    Lat: " + loc.getLatitude(), Toast.LENGTH_LONG).show();
    } catch (Exception ex) {
        Toast.makeText(this, ex.toString(), Toast.LENGTH_LONG).show();
    }
}


@Override
public void onLocationChanged(Location locFromGps) 
{
    this.loc = locFromGps;
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