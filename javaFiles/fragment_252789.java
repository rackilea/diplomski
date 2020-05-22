public class ParentSerializer extends StdSerializer<A> {
    public ParentSerializer() {
        super(A.class);
    }
    @Override
    public void serialize(A value, JsonGenerator gen, SerializerProvider  provider) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("id", value.getId());
        gen.writeEndObject();
    }
}