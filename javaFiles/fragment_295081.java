final class ClassKeyConverter
        extends Converter<Class<?>, String> {

    private static final Converter<Class<?>, String> classKeyConverter = new ClassKeyConverter();

    private ClassKeyConverter() {
    }

    static Converter<Class<?>, String> classKeyConverter() {
        return classKeyConverter;
    }

    @Override
    protected String doForward(final Class<?> a) {
        return a.toString();
    }

    @Override
    public Class<?> doBackward(final String b) {
        final Class<?> primitiveType = primitiveTypes.get(b);
        if ( primitiveType != null ) {
            return primitiveType;
        }
        final int prefix = b.startsWith(CLASS) ? CLASS.length()
                : b.startsWith(INTERFACE) ? INTERFACE.length()
                : -1;
        if ( prefix >= 0 ) {
            try {
                return Class.forName(b.substring(prefix));
            } catch ( final ClassNotFoundException ex ) {
                throw new RuntimeException(ex);
            }
        }
        throw new IllegalArgumentException(b);
    }

    private static final Map<String, Class<?>> primitiveTypes = ImmutableMap.<String, Class<?>>builder()
            .put("boolean", boolean.class)
            .put("byte", byte.class)
            .put("short", short.class)
            .put("int", int.class)
            .put("long", long.class)
            .put("float", float.class)
            .put("double", double.class)
            .put("char", char.class)
            .build();

    private static final String CLASS = "class ";
    private static final String INTERFACE = "interface ";

}