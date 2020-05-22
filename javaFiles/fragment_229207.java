@Provider
public class ObjectMapperProvider implements ContextResolver<ObjectMapper> {


     @Context
     UriInfo uriInfo;

    public ObjectMapperProvider() {
    }


    @Override
    public ObjectMapper getContext(Class<?> type) {
         ObjectMapper objectMapper = new ObjectMapper();
         SimpleModule module = new SimpleModule("SimpleModule", new org.codehaus.jackson.Version(1, 0, 0, null));
         module.addSerializer(BigInteger.class, new ToStringSerializer());
         objectMapper = objectMapper.configure(Feature.WRAP_ROOT_VALUE, false).configure(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE, false)
                 .configure(Feature.WRAP_EXCEPTIONS, true).configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, true).configure(Feature.WRITE_EMPTY_JSON_ARRAYS, false);
         final AnnotationIntrospector introspector = new JaxbAnnotationIntrospector();
         objectMapper.getDeserializationConfig().setAnnotationIntrospector(introspector); // using a deprecated API that works. Non-deprecated API doesn't work...
         objectMapper.getSerializationConfig().setAnnotationIntrospector(introspector);
         objectMapper.registerModule(module);
         return objectMapper;   
    }

}