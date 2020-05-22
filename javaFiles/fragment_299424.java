class AtomicStringTypeAdapter extends TypeAdapter<AtomicReference<String>> {

    @Override
    public AtomicReference<String> read(JsonReader in) throws IOException {

        AtomicReference<String> value = null;

        JsonParser jsonParser = new JsonParser();
        JsonElement je = jsonParser.parse(in);

        if (je instanceof JsonPrimitive) {
            value = new AtomicReference<String>();
            value.set(((JsonPrimitive) je).getAsString());
        } else if (je instanceof JsonObject) {
            JsonObject jsonObject = (JsonObject) je;
            value = new AtomicReference<String>();
            value.set(jsonObject.get("value").getAsString());
        }

        return value;
    }

    @Override
    public void write(JsonWriter out, AtomicReference<String> value) throws IOException {
        if (value != null) {
                out.beginObject();
                out.name("value").value(value.get());
                out.endObject();
        }
    }
}