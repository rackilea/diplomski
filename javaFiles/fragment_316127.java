MapperFacade mapper = new ConfigurableMapper() {
    @Override
    protected void configure(MapperFactory factory) {
    factory.registerMapper(new CustomMapper<A, Collection<B>>() {
        @Override
        public void mapAtoB(A a, Collection<B> b, MappingContext context) {                     b.addAll(mapperFacade.mapAsList(a.collection, B.class));

            for(B item : b) {
                item.propertyA = a.propertyA;
            }
        }               
    });             
    factory.registerConcreteType(Collection.class, ArrayList.class);
        }           
};  
final Type<Collection<B>> collectionOfB = new TypeBuilder<Collection<B>>() {}.build();
Collection<B> dest = mapper.map(source, TypeFactory.valueOf(A.class), collectionOfB);