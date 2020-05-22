class ForceNullsForMapTypeAdapterFactory implements TypeAdapterFactory {

    public final <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        if (Map.class.isAssignableFrom(type.getRawType())) {
            final TypeAdapter<T> delegate = gson.getDelegateAdapter(this, type);
            return createCustomTypeAdapter(delegate);
        }

        return null;
    }

    private <T> TypeAdapter<T> createCustomTypeAdapter(TypeAdapter<T> delegate) {
        return new TypeAdapter<T>() {
            @Override
            public void write(JsonWriter out, T value) throws IOException {
                final boolean serializeNulls = out.getSerializeNulls();
                try {
                    out.setSerializeNulls(true);
                    delegate.write(out, value);
                } finally {
                    out.setSerializeNulls(serializeNulls);
                }
            }

            @Override
            public T read(JsonReader in) throws IOException {
                return delegate.read(in);
            }
        };
    }
}