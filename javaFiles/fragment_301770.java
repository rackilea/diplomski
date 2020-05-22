final class PostValueTypeAdapterFactory
        implements TypeAdapterFactory {

    private static final TypeAdapterFactory postValueTypeAdapterFactory = new PostValueTypeAdapterFactory();

    private PostValueTypeAdapterFactory() {
    }

    static TypeAdapterFactory getPostValueTypeAdapterFactory() {
        return postValueTypeAdapterFactory;
    }

    @Override
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        final List<Field> valueFields = collectValueFields(typeToken.getRawType());
        if ( valueFields.isEmpty() ) {
            return null;
        }
        final TypeAdapter<T> delegateTypeAdapter = gson.getDelegateAdapter(this, typeToken);
        return new PostValueTypeAdapter<>(delegateTypeAdapter, valueFields);
    }

    // Just scan class the whole type hierarchy (except java.lang.Object) to find any occurrences of Value<T> fields
    private static List<Field> collectValueFields(final Class<?> type) {
        return StreamSupport.stream(subToSuperClass(type).spliterator(), false)
                .filter(clazz -> clazz != Object.class)
                .flatMap(clazz -> Stream.of(clazz.getDeclaredFields()))
                .filter(field -> field.getType() == Value.class)
                .peek(field -> field.setAccessible(true))
                .collect(toImmutableList());
    }

    private static final class PostValueTypeAdapter<T>
            extends TypeAdapter<T> {

        private final TypeAdapter<T> delegateTypeAdapter;
        private final List<Field> valueFields;

        private PostValueTypeAdapter(final TypeAdapter<T> delegateTypeAdapter, final List<Field> valueFields) {
            this.delegateTypeAdapter = delegateTypeAdapter;
            this.valueFields = valueFields;
        }

        @Override
        public void write(final JsonWriter out, final T value)
                throws IOException {
            delegateTypeAdapter.write(out, value);
        }

        @Override
        public T read(final JsonReader in)
                throws IOException {
            try {
                final T value = delegateTypeAdapter.read(in);
                for ( final Field valueField : valueFields ) {
                    // A Value<T> field is null? Make it undefined
                    if ( valueField.get(value) == null ) {
                        valueField.set(value, undefined());
                    }
                }
                return value;
            } catch ( final IllegalAccessException ex ) {
                throw new IOException(ex);
            }
        }

    }

}