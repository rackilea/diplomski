public static class DataObjectAdapter extends JsonSerializer<List<Utility>> {

    @Override
    public void serialize(final List<Utility> arg0, final JsonGenerator arg1, final SerializerProvider arg2)
            throws IOException {
        arg1.writeStartArray();
        for (Utility object : arg0) {
            arg1.writeStartObject();
            arg1.writeStringField("id", object.getId());
            arg1.writeStringField("title", object.getTitle());
            arg1.writeStringField("description", object.getDescription());
            arg1.writeEndObject();
        }
        arg1.writeEndArray();
    }

}