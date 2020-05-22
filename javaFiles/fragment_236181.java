@Bean
    public CastorMarshaller castorMarshaller() {
        ClassPathContextResource resource = new ClassPathContextResource("mapping.xml", getClass().getClassLoader());
        CastorMarshaller marshaller = new CastorMarshaller();
        marshaller.setMappingLocation(resource);
        return marshaller;
    }