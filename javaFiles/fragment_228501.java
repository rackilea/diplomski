@SuppressWarnings("unchecked")
Iterator<String> keys = (Iterator<String>) jsonObject.keys();
while (keys.hasNext()) {
    String key = keys.next();
    JSONObject value = jsonObject.getJSONObject(key);
    String component = value.getString("component");
    System.out.println(component);
}