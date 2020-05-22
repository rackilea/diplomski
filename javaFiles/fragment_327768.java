// Making HTTP request
try {
    // defaultHttpClient
    DefaultHttpClient httpClient = new DefaultHttpClient();
    HttpPost httpPost = new HttpPost(url);
    httpPost.setEntity(new UrlEncodedFormEntity(params));
    HttpResponse httpResponse = httpClient.execute(httpPost);

    try {
        // Get our response as a String.
        String jsonString = EntityUtils.toString(httpResponse.getEntity());
        Log.d(TAG, "JSON: "+jsonString);

        // Parse the JSON String into a JSONArray object.
        return new JSONArray(jsonString);
    } catch (JSONException e) {
        Log.e("JSON Parser", "Error parsing data " + e.toString());
    } catch (Exception e) {
        Log.e("Buffer Error", "Error converting result " + e.toString());
    }
} catch (UnsupportedEncodingException e) {
    e.printStackTrace();
} catch (ClientProtocolException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}
return null;