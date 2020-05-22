public class SwaggerSerializers implements MessageBodyWriter<Swagger> {

    @Override
    public boolean isWriteable(Class type, Type genericType, Annotation[] annotations,
                               MediaType mediaType) {
        return Swagger.class.isAssignableFrom(type);
    }