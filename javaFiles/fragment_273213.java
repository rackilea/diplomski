private final Map<Class<?>, Object> map = HashMap<>();

public void register(Class<?> clazz, Object value) {
    map.put(clazz, value);
}

public Object getValue(Class<?> clazz) {
    if (clazz == null) {
        return null;
    }
    Object value = map.get(clazz);
    if (value == null) {
        clazz = clazz.getSuperclass(); // May be null.
        return getValue(clazz);
    }
}