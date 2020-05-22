ObjectMapper mapper = new ObjectMapper();

String jsonString = "{\"key1\": 1, \"key2\": null, \"key3\": 3}";

ConcurrentHashMap<String, Object> map = mapper.readValue(jsonString, new ConcurrentHashMap<String, Object>() {
    @Override
    public Object put(String key, Object value) {
        return value != null ? super.put(key, value) : null;
    }
}.getClass());

System.out.println(map); // {key1=1, key3=3}