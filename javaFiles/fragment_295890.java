public class MyClassDeserializer extends JsonDeserializer<MyClass>{

    @Override
    public MyClass deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        int id = (Integer) ((IntNode) node.get("id")).numberValue();

        JsonNode categories = node.get("categories");
        Iterator<JsonNode> iter = categories.elements();

        while(iter.hasNext()){
            //create Category object based on an incrementing counter
        }

        MyClass myClass = //compose myClass from the values deserialized above.

        return myClass;
    }

}