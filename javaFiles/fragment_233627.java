@Override
protected void preReadFrom(Class<Object> type, Type genericType,
        Annotation[] annotations, MediaType mediaType,
        MultivaluedMap<String, String> httpHeaders,
        Unmarshaller unmarshaller) throws JAXBException {
    unmarshaller.setEventHandler(yourValidationEventHandler);
}