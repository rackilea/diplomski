public class DynamicMessageConverter implements HttpMessageConverter<Object> {

    private final HttpMessageConverter<Object> jsonConverter;
    private final HttpMessageConverter<String> stringConverter;

    public DynamicMessageConverter(HttpMessageConverter<Object> jsonConverter, HttpMessageConverter<String> stringConverter) {
        this.jsonConverter = jsonConverter;
        this.stringConverter = stringConverter;
    }

    @Override
    public boolean canWrite(Class clazz, MediaType mediaType) {
        return jsonConverter.canWrite(clazz, mediaType) || stringConverter.canWrite(clazz, mediaType);
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        List<MediaType> jsonMediaTypes = jsonConverter.getSupportedMediaTypes();
        List<MediaType> stringMediaTypes = stringConverter.getSupportedMediaTypes();
        List<MediaType> all = new ArrayList<>();
        all.addAll(jsonMediaTypes);
        all.addAll(stringMediaTypes);
        return all;
    }

    @Override
    public void write(Object o, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        if (o instanceof String) {
            stringConverter.write((String) o, contentType, outputMessage);
        } else {
            jsonConverter.write(o, contentType, outputMessage);
        }
    }

    @Override
    public boolean canRead(Class clazz, MediaType mediaType) {
        return false;
    }

    @Override
    public Object read(Class clazz, HttpInputMessage inputMessage) throws HttpMessageNotReadableException {
        throw new UnsupportedOperationException();
    }
}