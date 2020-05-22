protected ObjectMapper getObjectMapperForDeserialization() {
        ObjectMapper mapper = new ObjectMapper();

        StdTypeResolverBuilder typeResolverBuilder = new ObjectMapper.DefaultTypeResolverBuilder(ObjectMapper.DefaultTyping.OBJECT_AND_NON_CONCRETE);
        typeResolverBuilder = typeResolverBuilder.inclusion(JsonTypeInfo.As.PROPERTY);
        typeResolverBuilder.init(JsonTypeInfo.Id.CLASS, new ClassNameIdResolver(SimpleType.construct(Base.class), TypeFactory.defaultInstance()) {
            private HashMap<Class, Class> classes = new HashMap<Class, Class>() {
                {
                    put(ConcreteA.class, ConcreteAAdapter.class);
                    put(ConcreteB.class, ConcreteBAdapter.class);
                    put(ConcreteC.class, ConcreteCAdapter.class);
                }
            };

            @Override
            public String idFromValue(Object value) {
                return (classes.containsKey(value.getClass())) ? value.getClass().getName() : null;
            }

            @Override
            public JavaType typeFromId(String id) {
                try {
                    return classes.get(Class.forName(id)) == null ? super.typeFromId(id) : _typeFactory.constructSpecializedType(_baseType, classes.get(Class.forName(id)));
                } catch (ClassNotFoundException e) {
                    // todo catch the e
                }
                return super.typeFromId(id);
            }
        });
        mapper.setDefaultTyping(typeResolverBuilder);
        return mapper;
    }