JSONObject jsnobject = new JSONObject(String);

JSONArray jsonArray = jsnobject.getJSONArray("locations");
for (int i = 0; i < jsonArray.length(); i++) {
    JSONObject explrObject = jsonArray.getJSONObject(i);
}