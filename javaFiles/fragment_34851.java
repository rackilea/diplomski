public class CustomPropertyDeserializer extends StdDeserializer<Properties> {

    public CustomPropertyDeserializer() {
        super(Properties.class);
    }

    @Override
    public Properties deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String valueAsString = p.getValueAsString();
        String[] split = valueAsString.split(":");

        return new Properties(split[0], split[1]);
    }
}