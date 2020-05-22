public class JaxbJacksonObjectMapper extends ObjectMapper {

    public JaxbJacksonObjectMapper() {
        final AnnotationIntrospector introspector = new JaxbAnnotationIntrospector();

        this.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.UNWRAP_ROOT_VALUE, true);
        super.getDeserializationConfig().withAnnotationIntrospector(introspector);

        this.configure(org.codehaus.jackson.map.SerializationConfig.Feature.WRAP_ROOT_VALUE, true);
        super.getSerializationConfig().withAnnotationIntrospector(introspector);
    }
}