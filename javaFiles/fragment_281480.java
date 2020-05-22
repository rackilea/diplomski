public class MyDeser extends JsonDeserializer {
    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonToken t = p.getCurrentToken();
        if (t == JsonToken.VALUE_TRUE) {
            return Boolean.TRUE;
        }
        if (t == JsonToken.VALUE_FALSE) {
            return Boolean.FALSE;
        }
        return null; 
        // not parse int to bool but null and it may work ok.
        // if throw new IOException(), it will work fail. Maybe return null means use other deser to deal it. throw Exception means fail. I don't know it clearly.
    }
}