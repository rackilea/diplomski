public static boolean isOnline(Context c) {
    ConnectivityManager cm = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo netInfo = cm.getActiveNetworkInfo();
    if (netInfo != null && netInfo.isConnectedOrConnecting()) {
        return true;
    } else {
        Toast.makeText(c, "No Internet Connection.", Toast.LENGTH_SHORT).show();
    }
return false;