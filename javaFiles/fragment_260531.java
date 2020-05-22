/**
 *
 * @param context
 * @return true if connected to Internet
 *
 */
public static boolean isNetworkAvailable(final Context context) {
    final ConnectivityManager cm = (ConnectivityManager)
            context.getSystemService(Context.CONNECTIVITY_SERVICE);
    if (cm == null) return false;
    final NetworkInfo networkInfo = cm.getActiveNetworkInfo();
    // if no network is available networkInfo will be null
    // otherwise check if we are connected
    return (networkInfo != null && networkInfo.isConnected());
}