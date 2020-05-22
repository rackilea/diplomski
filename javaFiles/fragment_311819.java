public void getPositionAndGetWheater(View view) {
    LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
    if (location != null) {

        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        String longitudestring = String.valueOf(longitude);
        String latitudestring = String.valueOf(latitude);
        String URLforweather = "http://api.worldweatheronline.com/free/v1/weather.ashx?q=" + longitudestring + "," + latitudestring + "&format=xml&num_of_days=1&key=IHAVEAAPIKEYBUTI'MNOTPOSTINGITONTHEFORUMFORSECURITYREASONS";
        WebView webview = (WebView) findViewById(R.id.webview);
        webview.loadUrl(URLforweather);
    } else {
        //show error
    }

}