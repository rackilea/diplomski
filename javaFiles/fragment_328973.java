private static boolean isNumericValue(ParameterizedType t) {
    return isSubclassOf(t.getActualTypeArguments()[1], Number.class);
}

private static boolean isSubclassOf(Type t, Class<?> clazz) {
    if (t instanceof Class<?>)
        return clazz.isAssignableFrom((Class<?>) t);
    if (t instanceof ParameterizedType)
        return isSubclassOf(((ParameterizedType) t).getRawType(), clazz);
    Type[] bounds = null;
    if (t instanceof TypeVariable<?>)
        bounds = ((TypeVariable<?>) t).getBounds();
    if (t instanceof WildcardType)
        bounds = ((WildcardType) t).getUpperBounds();
    if (bounds != null && bounds.length > 0)
        return isSubclassOf(bounds[0], clazz);
    return clazz == Object.class;
}