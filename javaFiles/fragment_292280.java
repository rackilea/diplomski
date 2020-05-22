public class pk_http {

    public void execute(String s) {
        (new phpCall()).execute(s);
    }

    // Progress Dialog
    private ProgressDialog qDialog;

    // JSON parser class
    JSONParser jParser = new JSONParser();

    class phpCall extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... args) {
            // Building Parameters
            String url = args[0];
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            // getting JSON string from URL
            JSONObject json = jParser.makeHttpRequest(url, "GET", params);

            // TODO: return your result here, this will pass to onPostExecute(String)
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            // TODO: This is in UI thread, handle your result from doInBackground().
        }
    }
}