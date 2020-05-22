@Override
public T readFrom(Class<T> type, Type genericType,
        Annotation[] annotations, MediaType mediaType,
        MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
        throws IOException, WebApplicationException {

    try {
        JAXBContext jaxbContext = null;
        ContextResolver<JAXBContext> resolver = providers
                .getContextResolver(JAXBContext.class, mediaType);

        if(entityStream != null){
            // TODO read the entityStream and determine the concrete type of the XML content
            type = ... ;
        }

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