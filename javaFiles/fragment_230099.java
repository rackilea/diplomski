Log.v("MyApp", response);

JSONObject json = null;
try {
    json = new JSONObject(response);
} catch (JSONException e) {
    e.printStackTrace();
}

JSONArray jArr = json.getJSONArray("rows");

for (int i = 0; i < jArr.length(); i++) {
    JSONObject e;
    try {
        e = jArr.getJSONObject(i);
        Log.v("MyApp", "ID  : " + e.getString("id"));

    } catch (JSONException e1) {
        e1.printStackTrace();
    }
}