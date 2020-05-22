Map<String, String> objectWithDuplicates = new HashMap<>();
map.put("name", "MyName");
map.put("email", "em@ail");
map.put("EMAIL", "em@ail");

ObjectMapper mapper = new ObjectMapper();

String jsonWithDuplicates = mapper.writeValueAsString(objectWithDuplicates);
Map<String, Object> attributesWithDuplicates = mapper
        .readValue(jsonWithDuplicates, Map.class);

Map<String, Object> withoutDuplicates = new HashMap<>();
attributesWithDuplicates.forEach((key, value) -> {
    if (! withoutDuplicates.containsKey(key.toLowerCase())) {
        withoutDuplicates.put(key.toLowerCase(), value);
    }
});
String json = mapper.writeValueAsString(withoutDuplicates);