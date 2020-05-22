public class ImmutableMapTypeAdapterFactory implements TypeAdapterFactory {

    public static final ImmutableMapTypeAdapterFactory INSTANCE = new ImmutableMapTypeAdapterFactory();

    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        if (!ImmutableMap.class.isAssignableFrom(type.getRawType())) {
            return null;
        }
        final TypeAdapter<T> delegate = gson.getDelegateAdapter(this, type);
        return new TypeAdapter<T>() {
            @Override
            public void write(JsonWriter out, T value) throws IOException {
                delegate.write(out, value);
            }

            @Override
            @SuppressWarnings("unchecked")
            public T read(JsonReader in) throws IOException {
                return (T) ImmutableMap.copyOf((Map) delegate.read(in));
            }
        };
    }
}