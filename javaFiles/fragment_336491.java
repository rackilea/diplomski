public class CalendarDeserializer extends JsonDeserializer<Calendar>  {

    @Override
    public Calendar deserialize(JsonParser jp, DeserializationContext dc) 
            throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        int year = getInt("year", node);
        int month = getInt("month", node);
        int dayOfMonth = getInt("dayOfMonth", node);
        int hourOfDay = getInt("hourOfDay", node);
        int minute = getInt("minute", node);
        int second = getInt("second", node);

        Calendar c = Calendar.getInstance();
        c.set(year, month, dayOfMonth, hourOfDay, minute, second);
        return c;
    }

    private int getInt(String name, JsonNode node) {
        return (Integer) ((IntNode) node.get(name)).numberValue();
    } 
}