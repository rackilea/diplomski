public class CalendarSerializer extends JsonSerializer<Calendar> {

    private SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

    @Override
    public void serialize(Calendar calendar, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {

        String dateAsString = formatter.format(calendar.getTime());
        jsonGenerator.writeString(dateAsString);

    }
}