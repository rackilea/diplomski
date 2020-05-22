public static List<String> getDeserializationProperties(Class<?> beanType)
{
    ObjectMapper mapper = new ObjectMapper();
    JavaType type = mapper.getTypeFactory().constructType(beanType);
    BeanDescription desc = mapper.getSerializationConfig().introspect(type);
    return desc.findProperties().stream()
            .filter(def -> def.couldDeserialize())
            .map(def -> def.getName())
            .collect(Collectors.toList());
}