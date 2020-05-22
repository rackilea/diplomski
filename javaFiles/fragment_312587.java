public class CustomDeserializer extends StdDeserializer<Map> {
public CustomDeserializer() {
    super(Map.class);
}

@Override
public Map deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    Map<String, Object> result = new HashMap<String, Object>();
    jp.nextToken();
    while (!JsonToken.END_OBJECT.equals(jp.getCurrentToken())) {
        String key = jp.getText();
        jp.nextToken();
        if ("field1".equals(key)) {
            MyObject fiedlObj= jp.readValueAs(MyObject.class);
            //inject extra info
            //...
            result.put(key, fieldObj);
        } else {
            if (JsonToken.START_OBJECT.equals(jp.getCurrentToken())) {
                result.put(key, deserialize(jp, ctxt));
            } else if (JsonToken.START_ARRAY.equals(jp.getCurrentToken())) {
                jp.nextToken();
                List<Object> linkedList = new LinkedList<Object>();
                while (!JsonToken.END_ARRAY.equals(jp.getCurrentToken())) {
                    linkedList.add(deserialize(jp, ctxt));
                    jp.nextToken();
                }
                result.put(key, linkedList);
            } else {
                result.put(key, jp.readValueAs(Object.class));
            }
        }
        jp.nextToken();
    }
    return result;
}

}