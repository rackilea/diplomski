public static MultiMap<String,String> doDeserialization(String serializedString) throws JsonParseException, JsonMappingException, IOException {

    ObjectMapper mapper = new ObjectMapper();
    Class<MultiValueMap> classz = MultiValueMap.class;
    MultiMap map = mapper.readValue(serializedString, classz);
    return (MultiMap<String, String>) map;


}