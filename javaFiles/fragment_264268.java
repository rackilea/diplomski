public class WrapperTypeAdapter extends TypeAdapter<Wrapper> {
    @Override
    public final void write(JsonWriter out, Wrapper value) throws IOException {
        if(value == null) {
            out.nullValue();
            return;
        }

        // Don't worry about Write for now, obviously
    }

    @Override
    public final Wrapper read(JsonReader in) throws IOException {
        if(in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }

        Wrapper wrapper = new Wrapper();

        // HERE IS WHERE YOU GET TO WRITE CODE

        return wrapper;
    }
}