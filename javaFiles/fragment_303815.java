@Provider
public class CustomJSONWithPaddingProvider extends JSONWithPaddingProvider {

    @Override
    public void writeTo(final JSONWithPadding t,
                        final Class<?> type,
                        final Type genericType,
                        final Annotation[] annotations,
                        final MediaType mediaType,
                        final MultivaluedMap<String, Object> httpHeaders,
                        final OutputStream entityStream)
            throws IOException, WebApplicationException {

        final boolean isJavascript = mediaType
                .getSubtype().endsWith("+javascript");
        final MediaType mt = isJavascript ?
                new MediaType("application", "javascript") : mediaType;

        super.writeTo(t, type, genericType, annotations, mt, httpHeaders, entityStream);
    }
}