static <T extends Number> T parseString(String str, Class<T> cls) {
    if (cls == Float.class) {
        return (T) Float.valueOf(str);
    } else if (cls == Integer.class) {
        return (T) Integer.valueOf(str);
    }
    throw new IllegalArgumentException();
}