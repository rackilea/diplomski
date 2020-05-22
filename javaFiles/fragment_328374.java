final class PolymorphicTypeAdapterFactory
        implements TypeAdapterFactory {

    // Let's not hard-code `Kit.class` here and let a user pick up types at a call-site
    private final Predicate<? super Class<?>> predicate;

    private PolymorphicTypeAdapterFactory(final Predicate<? super Class<?>> predicate) {
        this.predicate = predicate;
    }

    static TypeAdapterFactory get(final Predicate<? super Class<?>> predicate) {
        return new PolymorphicTypeAdapterFactory(predicate);
    }

    @Override
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        final Class<? super T> rawClass = typeToken.getRawType();
        if ( !predicate.test(rawClass) ) {
            // Something we cannot handle? Try pick the next best type adapter factory
            return null;
        }
        // This is what JsonDeserializer fails at:
        final TypeAdapter<T> writeTypeAdapter = gson.getDelegateAdapter(this, typeToken);
        // Despite it's possible to use the above type adapter for both read and write, what if the `type` property points to another class?
        final Function<? super Class<T>, ? extends TypeAdapter<T>> readTypeAdapterResolver = actualRawClass -> {
            if ( !rawClass.isAssignableFrom(actualRawClass) ) {
                throw new IllegalStateException("Cannot parse as " + actualRawClass);
            }
            return gson.getDelegateAdapter(this, TypeToken.get(actualRawClass));
        };
        return PolymorphicTypeAdapter.get(rawClass, writeTypeAdapter, readTypeAdapterResolver);
    }

    private static final class PolymorphicTypeAdapter<T>
            extends TypeAdapter<T> {

        private final Class<? super T> rawClass;
        private final TypeAdapter<T> writeTypeAdapter;
        private final Function<? super Class<T>, ? extends TypeAdapter<T>> readTypeAdapterResolver;

        private PolymorphicTypeAdapter(final Class<? super T> rawClass, final TypeAdapter<T> writeTypeAdapter,
                final Function<? super Class<T>, ? extends TypeAdapter<T>> readTypeAdapterResolver) {
            this.rawClass = rawClass;
            this.writeTypeAdapter = writeTypeAdapter;
            this.readTypeAdapterResolver = readTypeAdapterResolver;
        }

        // Since constructors are meant only to assign parameters to fields, encapsulate the null-safety handling in the factory method
        private static <T> TypeAdapter<T> get(final Class<? super T> rawClass, final TypeAdapter<T> writeTypeAdapter,
                final Function<? super Class<T>, ? extends TypeAdapter<T>> readTypeAdapterResolver) {
            return new PolymorphicTypeAdapter<>(rawClass, writeTypeAdapter, readTypeAdapterResolver)
                    .nullSafe();
        }

        @Override
        @SuppressWarnings("resource")
        public void write(final JsonWriter jsonWriter, final T value)
                throws IOException {
            jsonWriter.beginObject();
            jsonWriter.name("type");
            jsonWriter.value(rawClass.getName());
            jsonWriter.name("properties");
            writeTypeAdapter.write(jsonWriter, value);
            jsonWriter.endObject();
        }

        @Override
        public T read(final JsonReader jsonReader)
                throws IOException {
            jsonReader.beginObject();
            // For simplicity's sake, let's assume that the class property `type` always precedes the `properties` property
            final Class<? super T> actualRawClass = readActualRawClass(jsonReader);
            final T value = readValue(jsonReader, actualRawClass);
            jsonReader.endObject();
            return value;
        }

        private Class<? super T> readActualRawClass(final JsonReader jsonReader)
                throws IOException {
            try {
                requireProperty(jsonReader, "type");
                final String value = jsonReader.nextString();
                @SuppressWarnings("unchecked")
                final Class<? super T> actualRawClass = (Class<? super T>) Class.forName(value);
                return actualRawClass;
            } catch ( final ClassNotFoundException ex ) {
                throw new AssertionError(ex);
            }
        }

        private T readValue(final JsonReader jsonReader, final Class<? super T> rawClass)
                throws IOException {
            requireProperty(jsonReader, "properties");
            @SuppressWarnings("unchecked")
            final Class<T> castRawClass = (Class<T>) rawClass;
            final TypeAdapter<T> readTypeAdapter = readTypeAdapterResolver.apply(castRawClass);
            return readTypeAdapter.read(jsonReader);
        }

        private static void requireProperty(final JsonReader jsonReader, final String propertyName)
                throws IOException {
            final String name = jsonReader.nextName();
            if ( !name.equals(propertyName) ) {
                throw new JsonParseException("Unexpected property: " + name);
            }
        }

    }

}