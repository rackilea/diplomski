protected ObjectMapper getObjectMapperForSerialization() {
    ObjectMapper mapper = new ObjectMapper();

    StdTypeResolverBuilder typeResolverBuilder = new ObjectMapper.DefaultTypeResolverBuilder(ObjectMapper.DefaultTyping.OBJECT_AND_NON_CONCRETE);
    typeResolverBuilder = typeResolverBuilder.inclusion(JsonTypeInfo.As.PROPERTY);
    typeResolverBuilder.init(JsonTypeInfo.Id.CLASS, new ClassNameIdResolver(SimpleType.construct(Base.class), TypeFactory.defaultInstance()));
    mapper.setDefaultTyping(typeResolverBuilder);

    return mapper;
}