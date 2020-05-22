public class MyActivity extends Activity{
...

LocationManager manager;
GetLocation listener;

@Override
    protected void onCreate() {
manager = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
listener = new GetLocation();

@Override
    protected void onResume() {
        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
    }

    @Override
    protected void onPause() {
        manager.removeUpdates(listener);
    }