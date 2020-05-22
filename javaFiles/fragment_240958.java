Map<String, String> map1 = new HashMap<String, String>();
Map<String, Integer> map2 = new HashMap<String, Integer>();
Map<String, Object> mergedRequestParam = new HashMap<>();
mergedRequestParam.putAll(map1);
mergedRequestParam.putAll(map2);
ObjectMapper objectMapper = new ObjectMapper(); 
String mapToJson = objectMapper.writeValueAsString(mergedRequestParam);