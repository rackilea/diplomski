@Provider
public class FormDataReader implements MessageBodyReader<Object> {

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return mediaType.isCompatible(MediaType.APPLICATION_FORM_URLENCODED_TYPE);
    }

    @Override
    public Object readFrom(Class<Object> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {
        String queryString = IOUtils.toString(entityStream);

        Object result = type.newInstance();
        BeanUtils.copyProperties(result, getUrlParameters(queryString));
        return result;
    }

    public static Map<String, String> getUrlParameters(String queryString)
            throws UnsupportedEncodingException {
        Map<String, String> params = new HashMap<String, String>();
        for (String param : queryString.split("&")) {
            String pair[] = param.split("=");
            String key = URLDecoder.decode(pair[0], "UTF-8");
            String value = "";
            if (pair.length > 1) {
                value = URLDecoder.decode(pair[1], "UTF-8");
            }
            params.put(new String(key), new String(value));
        }
        return params;
    }

}