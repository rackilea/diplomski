@Provider
public class MyJackonXmlProvier extends JacksonJaxbXMLProvider {

    @Context
    private ResourceInfo info;

    @Override
    public void writeTo(Object value, Class<?> type, Type genericType,
                        Annotation[] annotations, MediaType mediaType,
                        MultivaluedMap<String,Object> httpHeaders, 
                        OutputStream entityStream) {

        // do same thing as example above
        super.writeTo(pass, all, arguments)
}