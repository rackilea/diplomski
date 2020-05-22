@Override
protected Object readFrom(
        Class<Object> type,
        MediaType mediaType,
        Unmarshaller u,
        InputStream entityStream)
        throws JAXBException
{
    final SAXSource source = getSAXSource(spf.provide(), entityStream);
    ValidationEventCollector eventCollector = new ValidationEventCollector();
    ValidatingUnmarshallerListener listener = new ValidatingUnmarshallerListener(eventCollector);
    u.setEventHandler(eventCollector);
    u.setListener(listener);

    final Object result;
    if (type.isAnnotationPresent(XmlRootElement.class))
    {
        result = u.unmarshal(source);
    }
    else
    {
        result = u.unmarshal(source, type).getValue();
    }

    if (eventCollector.hasEvents())
    {
        HttpError error = new HttpError(Response.Status.BAD_REQUEST);

        for (ValidationEvent event : eventCollector.getEvents())
        {
            error.addMessage(ValidationUtil.toString(event));
        }

        throw new WebApplicationException(error.toResponse());
    }

    return result;
}