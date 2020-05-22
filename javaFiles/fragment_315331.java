JSONArray jsonarray = new JSONArray(jsonStr);
for (int i = 0; i < jsonarray.length(); i++) {
   JSONObject jsonobject = jsonarray.getJSONObject(i);
   String id = jsonobject.getString("id");
   String value = jsonobject.getString("value");
}