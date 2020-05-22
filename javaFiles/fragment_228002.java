public static boolean isNetworkAvailable(Context c) {
    NetworkInfo netInfo = null;
    try {
        ConnectivityManager cm = (ConnectivityManager) c
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        netInfo = cm.getActiveNetworkInfo();
    } catch (SecurityException e) {
        e.printStackTrace();
    }
    return netInfo != null && netInfo.isConnectedOrConnecting();
}