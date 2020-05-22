public class MainActivity extends ActionBarActivity {

private GoogleLocationService googleLocationService;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    googleLocationService = new GoogleLocationService(context, new LocationUpdateListener() {
    @Override
    public void canReceiveLocationUpdates() {
    }

    @Override
    public void cannotReceiveLocationUpdates() {
    }

    //update location to our servers for tracking purpose
    @Override
    public void updateLocation(Location location) {
        if (location != null ) {
            Timber.e("updated location %1$s %2$s", location.getLatitude(), location.getLongitude());

        }
    }

    @Override
    public void updateLocationName(String localityName, Location location) {

        googleLocationService.stopLocationUpdates();
    }
});
googleLocationService.startUpdates();


}

@Override
public void onDestroy() {
    super.onDestroy();
if (googleLocationService != null) {
    googleLocationService.stopLocationUpdates();
}

}
}