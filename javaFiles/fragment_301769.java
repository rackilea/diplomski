final class ValueTypeAdapterFactory
        implements TypeAdapterFactory {

    private static final TypeAdapterFactory valueTypeAdapterFactory = new ValueTypeAdapterFactory();

    private ValueTypeAdapterFactory() {
    }

    static TypeAdapterFactory getValueTypeAdapterFactory() {
        return valueTypeAdapterFactory;
    }

    @Override
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        if ( !Value.class.isAssignableFrom(typeToken.getRawType()) ) {
            return null;
        }
        final Type valueTypeParameter = getTypeParameter0(typeToken.getType());
        // Some boring Java unchecked stuff here...
        @SuppressWarnings("unchecked")
        final TypeAdapter<Object> innerTypeAdapter = (TypeAdapter<Object>) gson.getDelegateAdapter(this, TypeToken.get(valueTypeParameter));
        final TypeAdapter<Value<Object>> outerTypeAdapter = new ValueTypeAdapter<>(innerTypeAdapter);
        @SuppressWarnings("unchecked")
        final TypeAdapter<T> typeAdapter = (TypeAdapter<T>) outerTypeAdapter;
        return typeAdapter;
    }

    private static final class ValueTypeAdapter<T>
            extends TypeAdapter<Value<T>> {

        private final TypeAdapter<T> innerTypeAdapter;

        private ValueTypeAdapter(final TypeAdapter<T> innerTypeAdapter) {
            this.innerTypeAdapter = innerTypeAdapter;
        }

        @Override
        public void write(final JsonWriter out, final Value<T> value)
                throws IOException {
            if ( value.isValue() ) {
                final T innerValue = value.getValue();
                innerTypeAdapter.write(out, innerValue);
                return;
            }
            // Considering no-value is undefined in order not to produce illegal JSON documents (dangling property names, etc)
            if ( value.isNoValue() || value.isUndefined() ) {
                innerTypeAdapter.write(out, null);
                return;
            }
            throw new AssertionError();
        }

        @Override
        public Value<T> read(final JsonReader in)
                throws IOException {
            final JsonToken token = in.peek();
            if ( token == NULL ) {
                in.nextNull();
                return noValue();
            }
            return value(innerTypeAdapter.read(in));
        }

    }

}