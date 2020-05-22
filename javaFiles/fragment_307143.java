public static boolean isConnected(Context context) {

    ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo[] allNetworks = cm.getAllNetworkInfo();

    for (NetworkInfo networkInfo : allNetworks) {
        if (networkInfo.isAvailable() && networkInfo.isConnected()) {
            return true;
        }

    }

    return false;
}