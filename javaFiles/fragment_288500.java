public class MyObjectDeserializer extends StdDeserializer<MyObject> {
    public MyObjectDeserializer() {
        super(MyObject.class);
    }

    @Override
    public MyObject deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        ObjectMapper mapper = (ObjectMapper) parser.getCodec();
        MyObject myObject = SomeMagic.createMyObject();
        return mapper.readerForUpdating(myObject).readValue(parser);
    }
}