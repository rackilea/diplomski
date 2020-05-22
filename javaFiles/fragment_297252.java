public static <T> T fromJson(String jsonString, Class<T> classType) {
    ObjectMapper mapper = new ObjectMapper();
    mapper.setSerializationInclusion(Include.NON_NULL);
    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    mapper.registerModule(new JodaModule());

    try {
        return mapper.readValue(jsonString, classType);
    } catch(IOException var4) {
        var4.printStackTrace();
        return null;
    }
}