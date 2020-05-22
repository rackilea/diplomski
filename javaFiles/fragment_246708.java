private String tryObjMapper(Object obj) {
    String retVal = null;//or other default value
    try {
        retVal = objectMapper.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
        e.printStackTrace();
    }
    return retVal ;
}