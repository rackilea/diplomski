private static boolean isProviderActive;
@Override
public void onReceive(Context context, Intent intent) {
    LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    if (lm.isProviderEnabled(LocationManager.GPS_PROVIDER) && lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
        Log.v("-> ", "GPS + NETWORK");
        isProviderActive = true;
    }

    else if (lm.isProviderEnabled(LocationManager.GPS_PROVIDER) && !lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
        Log.v("-> ", "GPS");
        isProviderActive = true;
    }

    else if (lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER) && !lm.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
        Log.v("-> ", "NETWORK");
        isProviderActive = true;
    }

    else
    {
        Log.v("-> ", "DISCONNECT");
        isProviderActive = false;
    }

    //Send value of isProviderActive to ProviderChangeReceiver_updateUI
    Intent i = new Intent(context, ProviderChangeReceiver_updateUI.class);
    i.putExtra("isProvidrActv", isProviderActive);
    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.sendBroadcast(i);
}