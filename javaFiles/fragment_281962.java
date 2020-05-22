public class MyActivity extends Activity implements LocationListener
{

    ...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ...

        locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        ... // do something

        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 2000, // every 2 seconds
                0, this);
    }

    ...

    public void onLocationChanged(Location arg0) {
        if (arg0 != null){
            double longitude = arg0.getLongitude();
            double latitude = arg0.getLatitude();

            ...
        }
    }

}