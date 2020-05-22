public class TeachersSerializer extends JsonSerializer<Set<Teacher>> {
    @Override
    public void serialize(Set<Teacher> values, JsonGenerator jgen, SerializerProvider provider) throws IOException {
       jgen.writeStartArray();
       for (Teacher value : values) {
          jgen.writeStartObject();
          jgen.writeNumberField("id", value.getId());
          jgen.writeEndObject();
       }
       jgen.writeEndArray();
    }
}