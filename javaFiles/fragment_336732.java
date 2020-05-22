public static Class<?> parameterizedClass(final Class<?> root, final Class<?> target, final int paramIndex)
        throws ClassNotFoundException {

    final Type[] sooper = root.getGenericInterfaces();
    for (final Type t : sooper) {
        if (!(t instanceof ParameterizedType)) {
            continue;
        }
        final ParameterizedType type = ((ParameterizedType) t);
        if (type.getRawType().getTypeName().equals(target.getTypeName())) {
            return Class.forName(type.getActualTypeArguments()[paramIndex].getTypeName());
        }
    }
    for (final Class<?> parent : root.getInterfaces()) {
        final Class<?> result = parameterizedClass(parent, target, paramIndex);
        if (result != null) {
            return result;
        }
    }
    return null;
}

public static Class<?> parameterizedClass(final Object object, final Class<?> target, final int paramIndex)
        throws ClassNotFoundException {
    return parameterizedClass(object.getClass(), target, paramIndex);
}