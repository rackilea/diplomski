public static void getLatLongFromAddress(String youraddress) {
String uri = "http://maps.google.com/maps/api/geocode/json?address=" +
              youraddress + "&sensor=false";
HttpGet httpGet = new HttpGet(uri);
HttpClient client = new DefaultHttpClient();
HttpResponse response;
StringBuilder stringBuilder = new StringBuilder();

try {
    response = client.execute(httpGet);
    HttpEntity entity = response.getEntity();
    InputStream stream = entity.getContent();
    int b;
    while ((b = stream.read()) != -1) {
        stringBuilder.append((char) b);
    }
} catch (ClientProtocolException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}

JSONObject jsonObject = new JSONObject();
try {
    jsonObject = new JSONObject(stringBuilder.toString());

    double lng = ((JSONArray)jsonObject.get("results")).getJSONObject(0)
        .getJSONObject("geometry").getJSONObject("location")
        .getDouble("lng");

    double lat = ((JSONArray)jsonObject.get("results")).getJSONObject(0)
        .getJSONObject("geometry").getJSONObject("location")
        .getDouble("lat");

    Log.d("latitude", "" + lat);
    Log.d("longitude", "" + lng);
} catch (JSONException e) {
    e.printStackTrace();
}

}