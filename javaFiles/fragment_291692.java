public class CustomDeserializer implements JsonDeserializer<List<Map<Integer, String>>>{

        @Override
        public List<Map<Integer, String>> deserialize(JsonElement element, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            List<Map<Integer, String>> randomList = new ArrayList<>();
            JsonObject parentJsonObject = element.getAsJsonObject();
            Map<Integer, String> childMap;
            for(Map.Entry<String, JsonElement> entry : parentJsonObject.entrySet()){
                childMap = new HashMap<>();
                for(Map.Entry<String, JsonElement> entry1 : entry.getValue().getAsJsonObject().entrySet()){
                    childMap.put(Integer.parseInt(entry1.getKey()), entry1.getValue().toString());
                }
                randomList.add(childMap);
            }
            return randomList;
        }
    }