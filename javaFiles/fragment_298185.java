public class MainActivity extends FragmentActivity implements LocationListener {
    Location location;
    void onCreate() {
        ....
        location = locationManager.getLastKnownLocation(provider);
        ....
    }
}