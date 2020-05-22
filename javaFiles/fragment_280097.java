JSONObject data = new JSONObject(json);
JSONArray jsonArray = data.getJSONArray("childrens");
for (Object o : jsonArray) {
    String child = (String)o;
    Log.d("DEBUG", child);
}