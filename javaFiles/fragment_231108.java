public class LocalDateTimeWithNanoSerializer extends StdSerializer<LocalDateTime> {

    public LocalDateTimeWithNanoSerializer() {
        super(LocalDateTime.class);
    }

    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartArray();
        gen.writeNumber(value.getYear());
        gen.writeNumber(value.getMonthValue());
        gen.writeNumber(value.getDayOfMonth());
        gen.writeNumber(value.getHour());
        gen.writeNumber(value.getMinute());
        gen.writeNumber(value.getSecond());
        gen.writeNumber(value.getNano());
        gen.writeEndArray();
    }
}