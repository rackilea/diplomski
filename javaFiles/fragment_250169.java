public static void main(String[] args) {
    String testJSON = "{\"TestKey\": \"TEST\", \"Test spaces\": { \"child spaces 1\": \"child value 1\", \"child spaces 2\": \"child value 2\" } }";
    Map oldJSONObject = new Gson().fromJson(testJSON, Map.class);
    JsonObject newJSONObject = iterateJSON(oldJSONObject);

    Gson someGson = new Gson();
    String outputJson = someGson.toJson(newJSONObject);
    System.out.println(outputJson);
}

private static JsonObject iterateJSON(Map JSONData) {
    JsonObject newJSONObject = new JsonObject();
    Set jsonKeys = JSONData.keySet();
    Iterator<?> keys = jsonKeys.iterator();
    while(keys.hasNext()) {
        String currentKey = (String) keys.next();
        String newKey = currentKey.replaceAll(" ", "_");
        if (JSONData.get(currentKey) instanceof Map) {
            JsonObject currentValue = iterateJSON((Map) JSONData.get(currentKey));
            newJSONObject.add(currentKey, currentValue);
        } else {
            String currentValue = (String) JSONData.get(currentKey);
            newJSONObject.addProperty(newKey, currentValue);
        }
    }
    return newJSONObject;
}