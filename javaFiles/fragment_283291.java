public class AsyncTaskParseJson extends AsyncTask<String, String, String> {

  @Override
  protected void onPreExecute() {}

  @Override
  protected String doInBackground(String... arg0)  {
    String url = arg0[0]; // this is your passed url
    try {
        // create new instance of the httpConnect class
        httpConnect jParser = new httpConnect();

        // get json string from service url
        String json = jParser.getJSONFromUrl(ServiceUrl);

        // save returned json to your test string
        jsonTest = json.toString();

    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
  }

  @Override
  protected void onPostExecute(String strFromDoInBg) {
    textLastLocation = (TextView) findViewById(R.id.lastlocation);
    textLastLocation.setText(jsonTest);
  }
}