public CustomObjectMapper()
{
    super();

    SimpleModule stringModule = new SimpleModule("StringModule", new Version(1, 0, 0, null)).addDeserializer(String.class, new CustomStringDeserializer());
    registerModule(stringModule);
}

private static class CustomStringDeserializer extends JsonDeserializer<String>
{

    @Override
    public String deserialize(JsonParser parser, DeserializationContext context) throws IOException
    {
        if (parser.getCurrentToken() == JsonToken.VALUE_STRING)
        {
           String text = parser.getText();

           // Do whatever you want to the text here

           return text;
        }
    }
}