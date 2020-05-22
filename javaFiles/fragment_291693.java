public class CityListDeserializer implements JsonDeserializer<Map<String, Map<Integer, String>>>{

        @Override
        public Map<String, Map<Integer, String>> deserialize(JsonElement element, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            Map<String, Map<Integer, String>> randomList = new HashMap<>();
            JsonObject parentJsonObject = element.getAsJsonObject();
            Map<Integer, String> childMap;
            for(Map.Entry<String, JsonElement> entry : parentJsonObject.entrySet()){
                childMap = new HashMap<>();
                for(Map.Entry<String, JsonElement> entry1 : entry.getValue().getAsJsonObject().entrySet()){
                    childMap.put(Integer.parseInt(entry1.getKey()), entry1.getValue().toString());
                }
                randomList.put(entry.getKey(), childMap);
            }
            return randomList;
        }
    }