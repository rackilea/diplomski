import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

public class LocationActivity extends Activity {

double x,y;
Timer timer;
    LocationManager lm;
    boolean gps_enabled = false;
    boolean network_enabled = false;
/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
lm = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
if (!gps_enabled && !network_enabled) {  Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, "nothing is enabled", duration);
            toast.show();
}
if (gps_enabled)
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,
                    locationListenerGps);
        if (network_enabled)
            lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0,
                    locationListenerNetwork);
         timer=new Timer();
         timer.schedule(new GetLastLocation(), 20000);
}
LocationListener locationListenerGps = new LocationListener() {
        public void onLocationChanged(Location location) {
            timer.cancel();
            x =location.getLatitude();
            y = location.getLongitude();
            lm.removeUpdates(this);
            lm.removeUpdates(locationListenerNetwork);
Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, "gps enabled "+x + "\n" + y, duration);
            toast.show();
        }
public void onProviderDisabled(String provider) {
        }
public void onProviderEnabled(String provider) {
        }
public void onStatusChanged(String provider, int status, Bundle extras) {
        }
    };
LocationListener locationListenerNetwork = new LocationListener() {
        public void onLocationChanged(Location location) {
            timer.cancel();
            x = location.getLatitude();
            y = location.getLongitude();
            lm.removeUpdates(this);
            lm.removeUpdates(locationListenerGps);
Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, "network enabled"+x + "\n" + y, duration);
            toast.show();
        }
public void onProviderDisabled(String provider) {
        }
public void onProviderEnabled(String provider) {
        }
public void onStatusChanged(String provider, int status, Bundle extras) {
        }
    };
class GetLastLocation extends TimerTask {
        @Override
        public void run() {
             lm.removeUpdates(locationListenerGps);
             lm.removeUpdates(locationListenerNetwork);
Location net_loc=null, gps_loc=null;
             if(gps_enabled)
                 gps_loc=lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
             if(network_enabled)
                 net_loc=lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//if there are both values use the latest one
             if(gps_loc!=null && net_loc!=null){
                 if(gps_loc.getTime()>net_loc.getTime())
   {x = gps_loc.getLatitude();
                y = gps_loc.getLongitude();
                  Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, "gps lastknown "+x + "\n" + y, duration);
                    toast.show();
                }
                 else
   {x = net_loc.getLatitude();
                y = net_loc.getLongitude();
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, "network lastknown "+x + "\n" + y, duration);
                toast.show();
}
}
if(gps_loc!=null){
     {x = gps_loc.getLatitude();
                y = gps_loc.getLongitude();
                  Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, "gps lastknown "+x + "\n" + y, duration);
                    toast.show();
                  }
}
             if(net_loc!=null){
   {x = net_loc.getLatitude();
                y = net_loc.getLongitude();
              Context context = getApplicationContext();
              int duration = Toast.LENGTH_SHORT;
              Toast toast = Toast.makeText(context, "network lastknown "+x + "\n" + y, duration);
                toast.show();
}
             }
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, "no last know avilable", duration);
            toast.show();
}
}}