final class StaticTypeAdapterFactory
        implements TypeAdapterFactory {

    private static final TypeAdapterFactory staticTypeAdapterFactory = new StaticTypeAdapterFactory();

    private StaticTypeAdapterFactory() {
    }

    static TypeAdapterFactory getStaticTypeAdapterFactory() {
        return staticTypeAdapterFactory;
    }

    @Override
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        final Type type = typeToken.getType();
        if ( type.equals(Class.class) ) {
            @SuppressWarnings("unchecked")
            final TypeAdapter<T> castStaticTypeAdapter = (TypeAdapter<T>) getStaticTypeAdapter(gson);
            return castStaticTypeAdapter;
        }
        return null;
    }

}