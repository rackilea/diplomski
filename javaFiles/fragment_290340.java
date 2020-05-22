public JSONObject getJSONFromUrl2(String url) {
    StringBuilder builder = new StringBuilder();
    HttpClient client = new DefaultHttpClient();
    HttpGet httpGet = new HttpGet(url);
    try {
        HttpResponse response = client.execute(httpGet);
        StatusLine statusLine = response.getStatusLine();
        int statusCode = statusLine.getStatusCode();
        if (statusCode == 200) {
            HttpEntity entity = response.getEntity();
            InputStream content = entity.getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(content));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            return new JSONObject(builder.toString());
        } else {
            Log.e("==>", "No Response, Check Your API KEY");
            Toast.makeText(context,"Error Response, Check your API Key", Toast.LENGTH_LONG).show();
        }
    } catch (ClientProtocolException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (JSONException e) {
        Log.e("JSON Parser", "Error parsing data " + e.toString());
        Log.e("JSON Parser", json + url + e.toString());
    }
    return null; // only gets here on an error
}