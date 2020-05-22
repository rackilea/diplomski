protected Boolean doInBackground(Void... params) {
    if (isNetworkAvailable()) {
        try {
            HttpURLConnection urlc = (HttpURLConnection) (new URL( "http://www.google.com"    ).openConnection());
            urlc.connect();
            int resp = urlc.getResponseCode(); 
            return resp == 200;
        } catch (IOException e) {
            Log.e("DD", "Error checking internet connection", e);
        }
    } else {
        Log.d("DD", "No network available!");
    }
    return false;
}