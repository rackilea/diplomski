final class PostConstructTypeAdapterFactory
        implements TypeAdapterFactory {

    // No intermediate state, can be a singleton
    private static final TypeAdapterFactory postConstructTypeAdapterFactory = new PostConstructTypeAdapterFactory();

    private PostConstructTypeAdapterFactory() {
    }

    // However, making the constructor private encapsulates the way it's instantiated
    static TypeAdapterFactory getPostConstructTypeAdapterFactory() {
        return postConstructTypeAdapterFactory;
    }

    @Override
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        final List<Method> postConstructMethods = getPostConstructMethods(typeToken.getRawType());
        if ( postConstructMethods.isEmpty() ) {
            // If no post-construct methods found, just let Gson to pick up the next best-match type adapter itself
            return null;
        }
        // Obtain the "original" type adapter
        final TypeAdapter<T> delegateTypeAdapter = gson.getDelegateAdapter(this, typeToken);
        return new PostConstructTypeAdapter<>(delegateTypeAdapter, postConstructMethods);
    }

    private static List<Method> getPostConstructMethods(final Class<?> clazz) {
        if ( clazz.isPrimitive() ) {
            // Nothing to do with primitives
            return emptyList();
        }
        // The following stream operation collects all `@PostConstruct` methods
        // from java.lang.Object to the concrete class
        // where all @PostConstruct methods must satisfy the following conditions (differ from the original `@PostConstruct` contract):
        // * have no paramaters
        // * return nothing (but it looks like a too strict limitation, though)
        // * be annotated with `@PostConstruct`
        return superToSub(clazz)
                .stream()
                .flatMap(c -> Stream.of(c.getDeclaredMethods()))
                .filter(m -> {
                    final int parameterCount = m.getParameterCount();
                    if ( parameterCount != 0 ) {
                        return false;
                    }
                    final Class<?> returnType = m.getReturnType();
                    if ( returnType != void.class ) {
                        return false;
                    }
                    return m.isAnnotationPresent(PostConstruct.class);
                })
                .peek(m -> m.setAccessible(true))
                .collect(toList());
    }

    private static List<Class<?>> superToSub(final Class<?> clazz) {
        final List<Class<?>> hierarchy = subToSuper(clazz);
        Collections.reverse(hierarchy);
        return hierarchy;
    }

    private static List<Class<?>> subToSuper(final Class<?> clazz) {
        final List<Class<?>> hierarchy = new ArrayList<>();
        for ( Class<?> c = clazz; c != null; c = c.getSuperclass() ) {
            hierarchy.add(c);
        }
        return hierarchy;
    }

    private static final class PostConstructTypeAdapter<T>
            extends TypeAdapter<T> {

        private final TypeAdapter<T> delegateTypeAdapter;
        private final Iterable<Method> postConstructMethods;

        private PostConstructTypeAdapter(final TypeAdapter<T> delegateTypeAdapter, final Iterable<Method> postConstructMethods) {
            this.delegateTypeAdapter = delegateTypeAdapter;
            this.postConstructMethods = postConstructMethods;
        }

        @Override
        public void write(final JsonWriter out, final T value)
                throws IOException {
            // Nothing special to do on write, so just delegate the job
            delegateTypeAdapter.write(out, value);
        }

        @Override
        public T read(final JsonReader in)
                throws IOException {
            try {
                // Whilst on read there's a need to apply all post-construction methods
                final T read = delegateTypeAdapter.read(in);
                for ( final Method method : postConstructMethods ) {
                    method.invoke(read);
                }
                return read;
            } catch ( IllegalAccessException | InvocationTargetException ex ) {
                throw new IOException(ex);
            }
        }

    }

}