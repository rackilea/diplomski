class MapSerializer implements JsonSerializer<Map<String[], Boolean>> {
    @Override
    public JsonElement serialize(Map<String[], Boolean> src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject obj = new JsonObject();
        for(Map.Entry<String[], Boolean> entry : src.entrySet()) {
            obj.addProperty(Arrays.toString(entry.getKey()), entry.getValue());
        }
        return obj;
    }
}

class MapDeserializer implements JsonDeserializer<Map<String[], Boolean>> {
    @Override
    public Map<String[], Boolean> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Map<String[],Boolean> map = new HashMap<>();
        JsonObject obj = json.getAsJsonObject();
        for(Map.Entry<String, JsonElement> entry : obj.entrySet()) {
            String s = entry.getKey();
            //See how you're dependent of the String representation given by Arrays.toString? 
            //Not very convenient.
            map.put(s.substring(1, s.length()-1).split(", "), entry.getValue().getAsBoolean());
        }
        return map;
    }
}