public class NetworkBroadcastReceiver extends BroadcastReceiver {

    private static final String LOG_TAG = NetworkBroadcastReceiver.class.getSimpleName();

    @Override
    public void onReceive(final Context context, final Intent intent) {

        ConnectivityManager cm =
            (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        if (isConnected) {

            try {
                Intent uselessIntent = new Intent(context, SyncService.class);
                context.startService(uselessIntent);
            }catch (NullPointerException npe){
                npe.printStackTrace(System.err);
            }
        }
    }
}