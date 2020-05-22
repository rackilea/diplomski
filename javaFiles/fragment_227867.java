String items = jsonObject.getString("items");
JSONArray arr = new JSONArray(items);

for (int i=0; i < arr.length(); i++) {
    JSONObject jsonPart = arr.getJSONObject(i);
    JSONObject snippet = new JSONObject(jsonPart.getString("snippet"))
    Log.i("ID",snippet.getString("channelId"));
}