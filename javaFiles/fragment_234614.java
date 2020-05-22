public class MyCustomDeserializer extends JsonDeserializer<CustomClass> {
        @Override
        public CustomClass deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException
        {
            ...
        }
}