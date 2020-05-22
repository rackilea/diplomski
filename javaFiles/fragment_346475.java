Set<Map.Entry<String, JsonElement>> entrySet = ntw_Ports_obj
                .entrySet();

for (Map.Entry<String, JsonElement> entry : entrySet) {
    String key = entry.getKey();
    JsonArray jArray = (JsonArray) ntw_Ports_obj.get(key);
    System.out.println(jArray);
}