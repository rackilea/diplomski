import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;


public class MainActivity extends Activity {

    private LocationHandler locationUtility;
    private LocationManager mLocationManager = null;
    private IncomingHandler incomingHandler;

    /**
     * Handler of incoming messages from clients.
     */
    private static class IncomingHandler extends Handler {
        private WeakReference<MainActivity> mainActivityWeakReference;

        public IncomingHandler(MainActivity mainActivity) {
            mainActivityWeakReference = new WeakReference<>(mainActivity);
        }

        @Override
        public void handleMessage(Message message) {
            if (mainActivityWeakReference != null) {
                MainActivity mainActivity = mainActivityWeakReference.get();
                switch (message.what) {
                    case 0:

                        boolean isConnected = // check internet is connected
                        boolean isGPSEnabled = mainActivity.mLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
                        boolean isNetworkEnabled = mainActivity.mLocationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

                        if (!isConnected) {
                            // show alert or toast
                        }
                        if (!(isGPSEnabled && isNetworkEnabled)) {
                            // show alert or toast
                        }
                        if (mainActivity.locationUtility.mGoogleApiClient.isConnected()) {
                            mainActivity.locationUtility.startLocationUpdates(); // start updates
                        }
                        break;
                }
            }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        incomingHandler = new IncomingHandler(this);
        locationUtility = new LocationHandler(MainActivity.this, incomingHandler);
        mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    }

}