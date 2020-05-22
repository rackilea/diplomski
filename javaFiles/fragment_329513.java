public class DateTypeAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {

    public DateTypeAdapter() {
    }

    @Override 
    public synchronized JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(date.getTime());
    }

    @Override 
    public synchronized Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return new Date(Long.parseLong(jsonElement.getAsString()));
    }
}