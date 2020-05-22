public class LocalTimeDeserializer implements JsonDeserializer<LocalTime> {

    final DateTimeFormatter fmt = DateTimeFormat.forPattern("HH:mm");

    @Override
    public LocalTime deserialize(JsonElement paramJsonElement, Type paramType,
            JsonDeserializationContext paramJsonDeserializationContext) throws JsonParseException {

        return LocalTime.parse(paramJsonElement.getAsString(), fmt);
    }

}