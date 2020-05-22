final class NotNullTypeAdapterFactory
        implements TypeAdapterFactory {

    // The type adapter factory holds no state, so no need to instantiate it multiple times
    private static final TypeAdapterFactory notNullTypeAdapterFactory = new NotNullTypeAdapterFactory();

    private NotNullTypeAdapterFactory() {
    }

    static TypeAdapterFactory getNotNullTypeAdapterFactory() {
        return notNullTypeAdapterFactory;
    }

    @Override
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        final Collection<Field> notNullFields = getNotNullFields(typeToken.getRawType());
        // If no @NotNull fields found, then just tell Gson to pick the next best type adapter
        if ( notNullFields.isEmpty() ) {
            return null;
        }
        // If there's at least one @NotNull field, get the original type adapter
        final TypeAdapter<T> delegateTypeAdapter = gson.getDelegateAdapter(this, typeToken);
        return new TypeAdapter<T>() {
            @Override
            public void write(final JsonWriter out, final T value)
                    throws IOException {
                delegateTypeAdapter.write(out, value);
            }

            @Override
            public T read(final JsonReader in)
                    throws IOException {
                try {
                    // Read the value ...
                    final T value = delegateTypeAdapter.read(in);
                    // ... and make some post-processing
                    for ( final Field f : notNullFields ) {
                        if ( f.get(value) == null ) {
                            throw new MalformedJsonException(f + " has no value");
                        }
                    }
                    return value;
                } catch ( final IllegalAccessException ex ) {
                    throw new IOException(ex);
                }
            }
        };
    }

    private static Collection<Field> getNotNullFields(final Class<?> clazz) {
        // Primitive types and java.lang.Object do not have @NotNull
        if ( clazz.isPrimitive() || clazz == Object.class ) {
            return emptyList();
        }
        // Scan the whole hierarchy from the bottom subclass to the top superclass (except java.lang.Object we mentioned above)
        final Collection<Field> notNullFields = new ArrayList<>();
        for ( Class<?> c = clazz; c != Object.class; c = c.getSuperclass() ) {
            for ( final Field f : c.getDeclaredFields() ) {
                if ( f.isAnnotationPresent(NotNull.class) ) {
                    // Don't forget to make private fields accessible
                    f.setAccessible(true);
                    notNullFields.add(f);
                }
            }
        }
        return notNullFields;
    }

}