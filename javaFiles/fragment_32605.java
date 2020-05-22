public class CustomSerializer extends StdSerializer<Map<Object1, Object2>> {

    protected CustomSerializer() {
        super(Map.class, true);
    }

    @Override
    public void serialize(Map<Object1, Object2> map,
                          JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException{

        jsonGenerator.writeStartArray();
        for (Map.Entry<Object1,Object2> element: map.entrySet()) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeObjectField("key", element.getKey());
            jsonGenerator.writeObjectField("value", element.getValue());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();
    }
}