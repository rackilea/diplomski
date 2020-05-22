DozerBeanMapper mapper = new DozerBeanMapper();
List<String> excludeList = new ArrayList<>();
excludeList.add("fieldA");
BeanMappingBuilder builder = new BeanMappingBuilder() {
            protected void configure() {
                TypeMappingBuilder typeMappingBuilder = mapping(ClassA.class, ClassB.class);
                excludeList.forEach(typeMappingBuilder::exclude);
        };
mapper.addMapping(builder);