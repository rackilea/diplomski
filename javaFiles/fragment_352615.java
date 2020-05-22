class UnixTimestampDeserializer extends JsonDeserializer<DateTime> {
    Logger logger = LoggerFactory.getLogger(UnixTimestampDeserializer.class)

    @Override
    DateTime deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String timestamp = jp.getText().trim()

        try {
            return new DateTime(Long.valueOf(timestamp + '000'))
        } catch (NumberFormatException e) {
            logger.warn('Unable to deserialize timestamp: ' + timestamp, e)
            return null
        }
    }
}