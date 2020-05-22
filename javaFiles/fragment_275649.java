httpResponse response = client.execute(httpGet);

String result = convertInputStreamToString(response.getEntity());

JSONArray jsonArray = new JSONArray(result);

for (int i = 0; i < len; i++) {
    JSONObject obj = jsonArray.getJSONObject(i);
    String name = obj.getString("Name");
    //.... LocalityId or something...
}