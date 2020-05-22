class FooJsonDeserializer extends JsonDeserializer<Foo> {
    @Override
    public Foo deserialize(JsonParser parser, DeserializationContext context) throws IOException,
            JsonProcessingException {
        String[] array = parser.readValueAs(String[].class);
        int num = 0;
        Collection<String> collection = new ArrayList<String>();
        if (array.length > 0) {
            num = Integer.valueOf(array[0]);
            for (int index = 1; index < array.length; index++) {
                collection.add(array[index]);
            }
        }

        Foo foo = new Foo(num, collection);
        return foo;
    }
}