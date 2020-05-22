class BooleanKeyDeserializer extends JsonDeserializer<Object> {

@Override
public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    Object object = p.readValueAs(Object.class);
    if (!(object instanceof Boolean)) {
        // custom code here
    }
    return object;
}
}