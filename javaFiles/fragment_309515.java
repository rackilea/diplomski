public abstract class AbstractXmlValidationReader<T> implements
        MessageBodyReader<T> {

    private final Providers providers;
    private final Schema schema;

    public AbstractXmlValidationReader(final Providers providers,
            final ServletContext servletContext, final String xsdFileName) {
        this.providers = providers;

        try {
            SchemaFactory sf = SchemaFactory
                    .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            File xsd = new File(servletContext.getRealPath(xsdFileName));
            schema = sf.newSchema(xsd);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Unable to create XSD validation schema", e);
        }
    }

    @Override
    public boolean isReadable(Class<?> type, Type genericType,
            Annotation[] annotations, MediaType mediaType) {

        @SuppressWarnings("unchecked")
        Class<T> readableClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];

        if (type == readableClass
                && type.isAnnotationPresent(XmlRootElement.class)) {
            return true;
        }
        return false;
    }

    @Override
    public T readFrom(Class<T> type, Type genericType,
            Annotation[] annotations, MediaType mediaType,
            MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
            throws IOException, WebApplicationException {

        try {
            JAXBContext jaxbContext = null;
            ContextResolver<JAXBContext> resolver = providers
                    .getContextResolver(JAXBContext.class, mediaType);
            if (null != resolver) {
                jaxbContext = resolver.getContext(type);
            }
            if (null == jaxbContext) {
                jaxbContext = JAXBContext.newInstance(type);
            }
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            unmarshaller.setSchema(schema);

            @SuppressWarnings("unchecked")
            T entity = (T) unmarshaller.unmarshal(entityStream);
            return entity;
        } catch (JAXBException e) {
            throw new MessageBodyReaderValidationException(
                    "Failure while performing xml validation or xml marhalling!",
                    e);
        }
    }
}