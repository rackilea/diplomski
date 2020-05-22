locationManager = (LocationManager) MainActivity.this
            .getSystemService(Context.LOCATION_SERVICE); // #

    clickableButtonWithBorder.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {

                    locationListener = new LocationListener() {

                        @Override
                        public void onStatusChanged(String provider,
                                int status, Bundle extras) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        public void onProviderEnabled(String provider) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        public void onProviderDisabled(String provider) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        public void onLocationChanged(Location location) {

                            double MyLat = location.getLatitude();
                            double MyLong = location.getLongitude();
                            double MyAlt = location.getAltitude();
                            String MyProvider = location.getProvider();
                            float MyAccuracy = location.getAccuracy();
                            Object URI = "http://localhost/Binder.php?MyLat="
                                    + MyLat;
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Your current location is: " + MyLat
                                            + "\n" + MyLong + "\n" + MyAlt
                                            + "\n" + MyProvider + "\n"
                                            + MyAccuracy,
                                    Toast.LENGTH_SHORT).show();

                            NetworkOperation op = new NetworkOperation(MyLat);
                            op.execute("");

                        };
                    }; // #

                    locationManager.requestLocationUpdates(
                            LocationManager.GPS_PROVIDER, 0, 0, locationListener);

            // #
        }                                                                                                                     //#
}); 
    }      

    private class NetworkOperation extends AsyncTask<String, Void, String> {

    double MyLat;

    public NetworkOperation(double lat)
    {
        MyLat = lat;
    }


    @Override
    protected String doInBackground(String... params) {
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(
                    "http://10.33.146.21/Binder.php?MyLat="
                            + MyLat);
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            InputStream is = entity.getContent();

        } catch (Exception e) {
            Log.e("log_tag", "Error in http connection" + e.toString());
        }
        return "Executed";
    }

}