class ResourceJsonSerializer extends JsonSerializer<Resource> {
    @Override
    public void serialize(Resource value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeFieldName(value.getName());
        gen.writeObject(value.getItems());
        gen.writeEndObject();
    }
}

class ItemJsonSerializer extends JsonSerializer<Item> {

    @Override
    public void serialize(Item value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        writeMap(value.getSystemFields(), gen);
        writeMap(value.getDataFields(), gen);
        gen.writeEndObject();
    }

    private void writeMap(Map<String, String> map, JsonGenerator gen) throws IOException {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                gen.writeStringField(entry.getKey(), entry.getValue());
            }
        }
    }
}