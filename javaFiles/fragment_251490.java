final StaxEventItemReader<ProductDTO> itemReader = new StaxEventItemReader<>();
final Jaxb2Marshaller unMarshaller = new Jaxb2Marshaller();
final Map<String, Boolean> properties = Maps.newHashMap();
properties.put(UnmarshallerProperties.UNMARSHALLING_CASE_INSENSITIVE, Boolean.TRUE);
unMarshaller.setUnmarshallerProperties(properties);
itemReader.setUnmarshaller(unMarshaller);