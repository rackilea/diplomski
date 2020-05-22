private static TypeAdapter<Key<String>> keyAdapter = new TypeAdapter<Key<String>>() {
        @Override public void write(JsonWriter out, Key<String> value) throws IOException {
            out.value(value.value);
        }

        @Override public Key<String> read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            return new Key<String>(in.nextString());
        }
    };

    ...

    Gson gson = new GsonBuilder()
            .registerTypeAdapter(Key.class, keyAdapter)
            .create();