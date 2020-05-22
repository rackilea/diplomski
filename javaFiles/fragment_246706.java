private String tryObjMapper(Object obj) {
    try {
        return objectMapper.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
        e.printStackTrace();
        throw new RuntimeException("Failed to map obj +" obj, e);
    }
}