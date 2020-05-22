public class MyCustomDeserializer implements JsonDeserializer<MyCustomClass>
{
    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz");

    @Override
    public MyCustomClass deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext ctx) throws JsonParseException
    {
        JsonObject obj = json.getAsJsonObject();
        Entry<String, JsonElement> entry = obj.entrySet().iterator().next();
        if (entry == null) return null;
        Date date;
        try
        {
            date = df.parse(entry.getKey());
        }
        catch (ParseException e)
        {
            e.printStackTrace();
            date = null;
        }
        Long value = entry.getValue().getAsLong();
        return new MyCustomClass(date, value);
    }
}