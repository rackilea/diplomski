// Unfortunately keys() just returns a raw Iterator...
Iterator keys = jsonObject.keys();
while (keys.hasNext()) {
    Object key = keys.next();
    JSONObject value = jsonObject.getJSONObject((String) key);
    String component = value.getString("component");
    System.out.println(component);
}