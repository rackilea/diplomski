class QuoteCreator implements JsonDeserializer<Quote>
{

    public Quote deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException
    {
        Gson g = new Gson();
        Quote a = g.fromJson(json, Quote.class);
        a.setTest(a.getSymbol());
        return a;
    }
}