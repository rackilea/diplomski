if (returnType instanceof Class<?>) {
    Class<?> returnClass = (Class<?>)returnType;
    // do something with the class
}
else if (returnType instanceof ParameterizedType) {
    // This will be the case in your example
    ParameterizedType pt = (ParameterizedType)returnType;
    Type rawType = pt.getRawType();
    Type[] genericArgs = pt.getActualTypeArguments();

    // Here `rawType` is the class "java.util.List",
    // and `genericArgs` is a one element array containing the
    // class "cars".  So overall, pt is equivalent to List<cars>
    // as you'd expect.
    // But in order to work that out, you need
    // to call something like this method recursively, to
    // convert from `Type` to `Class`...
}
else if (...) // handle WildcardType, GenericArrayType, TypeVariable for completeness