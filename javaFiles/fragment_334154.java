JSONObject data = response.getJSONObject("data");
JSONArray jsonArray = new JSONArray();

Iterator<?> keys = data.keys();

while (keys.hasNext()) {
    String key = (String) keys.next();
    if (data.get(key) instanceof JSONObject) {
        jsonArray.put(((JSONObject) data.get(key)).getString("Value"));
    }
}
Log.e("TZX", String.valueOf(jsonArray));