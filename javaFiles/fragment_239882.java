@Produces("application/json")
public class IntWriter implements MessageBodyWriter<Integer> {

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        boolean intAsID = false;
        for (Annotation a : annotations) {
            if (a.annotationType().getCanonicalName().equals("com.blabla.IntAsID")) {
                intAsID = true;
                break;
            }
        }
        return intAsID && (type == Integer.class);
    }

    @Override
    public long getSize(Integer integer, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return 0;
    }

    @Override
    public void writeTo(Integer integer, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
        JsonGenerator generator = Json.createGenerator(entityStream);
        generator.writeStartObject()
                .write("id", integer)
                .writeEnd()
                .flush();
    }
}