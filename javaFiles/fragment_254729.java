public String updateValue(String keyPath, String updateText, String jsonText) {
    String[] keys = keyPath.split("/");
    JsonParser jsonParser = new JsonParser();
    JsonObject jsonObject = (JsonObject) jsonParser.parse(jsonText);
    JsonObject returnVal = jsonObject; // This holds the ref to target json object
    JsonPrimitive jp = new JsonPrimitive(updateText);
    String finalKey = keys[keys.length - 1];
    for(String key : keys)
    {
        if (jsonObject.get(key).isJsonObject())
        {
            jsonObject = (JsonObject)jsonObject.get(key);
        }
    }
    jsonObject.remove(finalKey);
    jsonObject.add(finalKey, jp);
    return returnVal.toString();      
}