static public Type getType(final Class<?> klass, final int pos) {
    // obtain anonymous, if any, class for 'this' instance
    final Type superclass = klass.getGenericSuperclass();

    // test if an anonymous class was employed during the call
    if ( !(superclass instanceof Class) ) {
        throw new RuntimeException("This instance should belong to an anonymous class");
    }

    // obtain RTTI of all generic parameters
    final Type[] types = ((ParameterizedType) superclass).getActualTypeArguments();

    // test if enough generic parameters were passed
    if ( pos < types.length ) {
        throw RuntimeException(String.format("Could not find generic parameter #%d because only %d parameters were passed", pos, types.length));
    }

    // return the type descriptor of the requested generic parameter
    return types[pos];
}