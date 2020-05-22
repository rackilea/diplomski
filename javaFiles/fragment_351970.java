public class MyClassSerializer extends JsonSerializer<MyClass> {
    private final JsonSerializer<Object> defaultSerializer;

    public MyClassSerializer(JsonSerializer<Object> defaultSerializer) {
        this.defaultSerializer = checkNotNull(defaultSerializer);
    }

    @Override
    public void serialize(MyClass myclass, JsonGenerator gen, SerializerProvider provider) throws IOException {
        if (myclass.getSomeProperty() == true) {
            provider.setAttribute("special", true);
        }
        defaultSerializer.serialize(myclass, gen, provider);
    }
}