public class ZonedDateTimeDeserializer extends JsonDeserializer<ZonedDateTime> {

    @Override
    public ZonedDateTime deserialize(JsonParser jsonParser,
                                     DeserializationContext deserializationContext)
                                     throws IOException {

        LocalDate localDate = LocalDate.parse(
                jsonParser.getText(), 
                DateTimeFormatter.ISO_LOCAL_DATE);

        return localDate.atStartOfDay(ZoneOffset.UTC);
    }
}