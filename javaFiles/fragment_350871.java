beanMerger.addMapping(
  new BeanMappingBuilder() {
    protected void configure() {
       mapping(MyObjectDTO.class, MyObjectDTO.class, TypeMappingOptions.mapNull(false));
    }
  });