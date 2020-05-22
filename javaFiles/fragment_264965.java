final class ArrayOrEmptyStringTypeAdapterFactory
        implements TypeAdapterFactory {

    private static final TypeAdapterFactory arrayOrEmptyStringTypeAdapterFactory = new ArrayOrEmptyStringTypeAdapterFactory();

    private ArrayOrEmptyStringTypeAdapterFactory() {
    }

    static TypeAdapterFactory getArrayOrEmptyStringTypeAdapterFactory() {
        return arrayOrEmptyStringTypeAdapterFactory;
    }

    @Override
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        if ( List.class.isAssignableFrom(typeToken.getRawType()) ) { // Is it an instance of java.util.List? Not that getRawType() and getType() have different purposes
            final TypeAdapter<List<Object>> typeAdapter = getArrayOrEmptyStringTypeAdapter(gson, getListElementType(typeToken.getType()));
            @SuppressWarnings("unchecked")
            final TypeAdapter<T> castTypeAdapter = (TypeAdapter<T>) typeAdapter;
            return castTypeAdapter;
        }
        return null;
    }

    private static Type getListElementType(final Type type) {
        return type instanceof ParameterizedType // Is it a generic type with type parameters?
                ? ((ParameterizedType) type).getActualTypeArguments()[0] // If yes, then we know that java.util.List has one type paremeter only
                : Object.class; // Otherwise it's a raw list, and no element type info is provided
    }

}