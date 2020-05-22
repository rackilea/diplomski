@SuppressWarnings("unchecked")
public static <T> T[] deepCopyArray(T[] array) {
    return (T[]) deepCopyArrayInternal(array);
}
private static Object deepCopyArrayInternal(Object array) {
    int length = Array.getLength(array);
    Object copy = Array.newInstance(array.getClass().getComponentType(), length);
    for (int i = 0; i < length; i++) {
        Object value = Array.get(array, i);
        if (value != null && value.getClass().isArray())
            value = deepCopyArrayInternal(value);
        Array.set(copy, i, value);
    }
    return copy;
}