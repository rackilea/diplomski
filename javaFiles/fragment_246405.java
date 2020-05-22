private <T> List<T> toList(Class<T> clazz, String json) {
    ObjectMapper mapper = new ObjectMapper();
    List<T> list = mapper.readValue(json, mapper.getTypeFactory()
                .constructCollectionType(List.class, clazz));
    return list;
}