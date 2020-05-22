class GetJSONTask extends AsyncTask<String, Void, JSONObject[]> {

 ...

 protected JSONObject[] doInBackground(String... urls) {
    // Creating new JSON Parser
    JSONParser jParser = new JSONParser();

    // Getting JSON from URL
    JSONObject[] jsons = new JSONObject[2];
    jsons[0] = jParser.getJSONFromUrl(url1);
    jsons[1] = jParser.getJSONFromUrl(url2);

    return jsons;
}
protected void onPostExecute(JSONObject[] jsons) {
    JSONObject json1 = jsons[0];
    JSONObject json2 = jsons[1];
    // do you work after this
}
}