public static <T> T deserialize(String json, Class<T> clazz) throws Exception {
    if (clazz instanceof Bean) {
        return wrappedObjectMapper.readValue(json, clazz);
    } else {
        return normalObjectMapper.readValue(json, clazz);
    }
}