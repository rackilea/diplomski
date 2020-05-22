@Bean
@Primary
public ObjectMapper objectMapper() {
  DefaultSerializerProvider serializerProvider = new DefaultSerializerProvider.Impl();
  serializerProvider.setNullValueSerializer(nullSerializer);
  ObjectMapper objectMapper = new ObjectMapper();
  objectMapper.setSerializerProvider(serializerProvider);
  return objectMapper;
}