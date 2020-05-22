public class ResetSerializer extends JsonSerializer<Collection> {

    @Override
    public void serialize(Collection t, JsonGenerator jg, SerializerProvider sp) throws IOException {
        if (t != null) {

            jg.writeStartArray();
            for (Object o: t) {
               jg.writeObject(o);
            }
            jg.writeEndArray();
            t.clear();
       }
    }
}