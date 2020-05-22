class XMLGregorianCalendarDeserializer extends GregorianCalendarDeserializer {

    private static final long serialVersionUID = 1L;

    @Override
    public XMLGregorianCalendar deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException {
        try {
            return super.deserialize(jp, ctxt);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}