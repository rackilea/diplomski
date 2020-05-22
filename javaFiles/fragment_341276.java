private ObjectMapper createObjectMapper() {
    final ObjectMapper mapper = new ObjectMapper();
    // enable toString method of enums to return the value to be mapped
    mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
    mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
    return mapper;
}