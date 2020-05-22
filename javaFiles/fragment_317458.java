try {
    HttpClient httpclient = new DefaultHttpClient();
    HttpPost httppost = new HttpPost("http://10.0.2.2:8888/obtePerfil.php");
    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
    HttpResponse response = httpclient.execute(httppost);
    HttpEntity entity = response.getEntity();

    //this line here is what saves a lot of work
    String result = EntityUtils.toString(entity, HTTP.UTF_8);

    // parse json data
    try {
        JSONArray jArray = new JSONArray(result);                           
        for (int i = 0; i < jArray.length(); i++) {
        JSONObject json_data = jArray.getJSONObject(i);
        TextView info = (TextView) findViewById(R.id.info);
        String sInfo = "id: " + json_data.getInt("ID")
                + ", descripció: "
                + json_data.getString("DESC") + ", nick: "
                + json_data.getString("NICK")
                + ", data de naixement: "
                + json_data.getString("DATA_NEIX");
        info.setText(sInfo);
        }
    } catch (Exception e) {
        Log.e("log_tag", "Error parsing data " + e.toString());
        }
} catch (Exception e) {
        Log.e("log_tag", "Error in http connection "+ e.toString());
        }