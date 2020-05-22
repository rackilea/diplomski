ArrayList<JSONObject> childList = new ArrayList<JSONObject>();
try {
    JSONArray childArray = MYJSON.getJSONArray("childObject0");
    for (int i = 0; i < childArray.length(); i++) {
        childList.add(childArray.getJSONObject(i));
    }
} catch (JSONException e) {
    e.printStackTrace();
}