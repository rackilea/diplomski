@RequiredArgsConstructor
private class GenericTypeAdapter<T> extends TypeAdapter<T> {

    // typeToken is needed when deserializing
    private final TypeToken<T> typeToken;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public void write(JsonWriter out, T value) throws IOException {
        // Altering could be done with some low level string manipulation
        // but JsonObject makes altering object more safe.
        // Feel free to comment for better way to instantiate it,
        // this is just for an example.
        JsonObject jsonObject = gson.fromJson(gson.toJson(value)
                            ,JsonElement.class).getAsJsonObject();
        // alter jsonObject in any way needed,
        // here is only added version information
        jsonObject.addProperty("version", 1);
        out.jsonValue(gson.toJson(jsonObject));
    }

    @Override
    public T read(JsonReader in) throws IOException {
        // maybe needless to mention but mention still:
        // here it is possible to init object in a way 
        // that provided JSON solely does not make possible
        return gson.fromJson(in, typeToken.getType());
    }
}