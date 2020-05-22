class ModelSerializer extends JsonSerializer<List<Model>> {

    @Override
    public void serialize(List<Model> value, JsonGenerator jgen,
            SerializerProvider provider) throws IOException {
        jgen.writeStartArray();
        for (Model model : value) {
            jgen.writeStartObject();
            jgen.writeObjectField("model", model);
            jgen.writeEndObject();    
        }
        jgen.writeEndArray();
    }

}