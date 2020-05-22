public static boolean hasActiveInternetConnection(Context context) {
    if (isNetworkAvailable(context)) {
        try {
            HttpURLConnection urlc = (HttpURLConnection) (new URL("http://www.google.com").openConnection());
            urlc.setRequestProperty("User-Agent", "Test");
            urlc.setRequestProperty("Connection", "close");
            urlc.setConnectTimeout(1500); 
            urlc.connect();
            return (urlc.getResponseCode() == 200);
        } catch (IOException e) {
        Log.e(LOG_TAG, "Error checking internet connection", e);
        }
    } else {
    Log.d(LOG_TAG, "No network available!");
    }
    return false;
}