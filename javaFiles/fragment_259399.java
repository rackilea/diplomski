public class Connection extends AsyncTask<Void, Void, Boolean> {

    private ConnectivityManager mConnectivityManager;
    private OnConnectionEstablishedListener mListener;

    public interface OnConnectionEstablishedListener {
        void onConnectionEstablished(boolean isReachable);
    }

    public Connection(ConnectivityManager connectivityManager, OnConnectionEstablishedListener listener) {
        mConnectivityManager = connectivityManager;
        mListener = listener;
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        final NetworkInfo netInfo = mConnectivityManager.getActiveNetworkInfo();
        boolean isReachable = false;

        if (netInfo != null && netInfo.isConnected()) {
            // Some sort of connection is open, check if server is reachable
            try {
                URL url = new URL(DataManager.SIMPLE_BASE_URL);
                HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
                urlc.setRequestProperty("User-Agent", "Android Application");
                urlc.setRequestProperty("Connection", "close");
                urlc.setConnectTimeout(10 * 2000);
                urlc.connect();
                isReachable = (urlc.getResponseCode() == 200);
            } catch (IOException e) {
                //Log.e(TAG, e.getMessage());
            }
        }
        return isReachable;
    }

    @Override
    protected void onPostExecute(Boolean isReachable) {
        super.onPostExecute(isReachable);
        mListener.onConnectionEstablished(isReachable);
    }
}