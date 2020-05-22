private static Type getRawClass(final Type type) {
    if ( type instanceof ParameterizedType ) {
        return ((ParameterizedType) type).getRawType();
    }
    return type;
}