public class CalendarDeserializer extends JsonDeserializer<Calendar> {

    private SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

    @Override
    public Calendar deserialize(JsonParser jsonParser,
                                DeserializationContext deserializationContext) 
                                throws IOException {

        String dateAsString = jsonParser.getText();

        try {
            Date date = formatter.parse(dateAsString);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar;
        } catch (Exception e) {
            throw new IOException(e);
        }
    }