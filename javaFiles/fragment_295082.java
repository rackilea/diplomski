final class ClassKeyMultimapTypeAdapterFactory
        implements TypeAdapterFactory {

    private static final TypeAdapterFactory classKeyMultimapTypeAdapterFactory = new ClassKeyMultimapTypeAdapterFactory();

    static final Type classKeyMultimapType = TypeToken.getParameterized(Multimap.class, Class.class, Object.class).getType();

    private ClassKeyMultimapTypeAdapterFactory() {
    }

    static TypeAdapterFactory classKeyMultimapTypeAdapterFactory() {
        return classKeyMultimapTypeAdapterFactory;
    }

    @Override
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        if ( !isClassKeyMultimap(typeToken) ) {
            return null;
        }
        @SuppressWarnings("unchecked")
        final TypeAdapter<T> typeAdapter = (TypeAdapter<T>) multimapTypeAdapter(classKeyConverter(), type -> gson.getDelegateAdapter(this, TypeToken.get(type)));
        return typeAdapter;
    }

    private static boolean isClassKeyMultimap(final TypeToken<?> typeToken) {
        if ( Multimap.class.isAssignableFrom(typeToken.getRawType()) ) {
            final Type type = typeToken.getType();
            if ( type instanceof ParameterizedType ) {
                final ParameterizedType parameterizedType = (ParameterizedType) type;
                if ( Class.class.equals(parameterizedType.getActualTypeArguments()[0]) ) {
                    // We expect to process `Multimap<Class<?>, ?>` only
                    return true;
                }
            }
        }
        return false;
    }

}