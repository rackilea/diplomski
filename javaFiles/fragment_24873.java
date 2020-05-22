private class Retrieve_Weather extends AsyncTask<Void, Void, String> {
    private final String TAG = "Retrieve_Weather";
    Connection con = null;

    protected Void doInBackground(String... params) {

        //Log.i(TAG, weatherline);
        Document doc = null;
        if (con !=null){
            try {
                Log.i(TAG, "trying document...");
                doc = con.get();
                Log.i(TAG, "after document");
                Element currentWeather = doc.getElementById("curCond");
                currentweather = currentWeather.text();
                Log.i(TAG, currentWeather.text());
                }
            catch (IOException except) {
                Log.i(TAG, "Cannot Connect", except);   
                except.printStackTrace();
                currentweather = "Can't Connect";
                Log.i(TAG, "End stacktrace");

            }

        }
        else{
            currentweather = "Connection returned null";
        }

        //Log.i(TAG, weatherline);
        return currentweather;

    }

    @Override
    protected void onPreExecute() {
        //Log.i(TAG, "onPreExecute");
        Log.i(TAG, "trying to connect...");
        con = Jsoup.connect("http://www.wunderground.com/cgi-bin/findweather/getForecast?query=zmw:02142.1.99999").userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:21.0) Gecko/20100101 Firefox/21.0");
        Log.i(TAG, "CONNECTED!!!");

        }




    @Override
    protected void onProgressUpdate(Void... values) {
        Log.i(TAG, "onProgressUpdate");
    }

    @Override
    protected void onPostExecute(Void result){
        Log.i(TAG, "onPostExecute");

    }


}