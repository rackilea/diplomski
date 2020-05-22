private String tryObjMapper(Object obj) {
    try {
        return objectMapper.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
        e.printStackTrace();
    }
    return null;//or other default value
}