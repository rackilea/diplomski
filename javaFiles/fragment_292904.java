import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;

public class Utils {

    public static boolean connectivity(Context c) {

        if(c != null)
        {
            ConnectivityManager connec = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
            try {
                android.net.NetworkInfo wifi = connec.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

                android.net.NetworkInfo mobile = connec.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

                if (wifi.isConnected()||mobile.isConnected())
                    return true;
                else if (wifi.isConnected() && mobile.isConnected())
                    return true;
                else
                    return false;

            } catch (NullPointerException e) {
                Log.d("ConStatus", "No Active Connection");
                return false;
            }
        }
        else
        {
            Log.v("utils--", "null");
            return false;
        }
    }

}