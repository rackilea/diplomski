BeanMappingBuilder foo = new BeanMappingBuilder() {

        @Override
        protected void configure() {
            mapping(OldPackage.class, NewPackage.class).fields("version", "version", FieldsMappingOptions.customConverter(ConverterImpl.class));
        }
    };
mapper.addMapping(foo);