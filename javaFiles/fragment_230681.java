public class FooSerializer extends JsonSerializer<Foo> {
    @Override
    public void serialize(final Foo value, final JsonGenerator jgen,
        final SerializerProvider provider) throws IOException
    {
        if (value.bar() == null) {
            jgen.writeString("");
        } else {
            jgen.writeString(value.bar());
        }
    }
}