public String convertObjectToJson(Object obj) {
    long start = System.currentTimeMillis();
    objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    objectMapper.getFactory().configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
    String jsonBody = null;
    try {
        jsonBody = objectMapper.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
        logger.info(e.getMessage(), e.fillInStackTrace());
    }
    logger.debug("Conversion time for object to json :: " + (System.currentTimeMillis() - start) / 1000d);
    return jsonBody;
}