public static List<String> getValuesAsListFromJson2Lvl(String s, String key) throws  JSONException {
    JSONArray jsonArray = new JSONArray(s);
    List<String> values = new ArrayList<String>();
    for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject jsonObject = jsonArray.getJSONObject(i);
        String value = jsonObject.get(key).toString();
        values.add(value);
    }
    return values;
}