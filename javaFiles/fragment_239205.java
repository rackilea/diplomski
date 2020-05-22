@SuppressWarnings("unchecked")
public static <T extends Enum<T>> void some_method(Class<T> clazz, String name) {
    Map<String, Enum<?>> enumMap = enumsMap.get(clazz);
    if (enumMap == null) {
        enumMap = new HashMap<String, Enum<?>>();
        for (T t : clazz.getEnumConstants()) {
            enumMap.put(t.name(), t);
        }
        enumsMap.put(clazz, enumMap);
    }
    T t = (T) enumMap.get(name);
    if (t != null) {
        // name matches to one of enum values, do something with it
    } else {
        // name doesn't matches to any of enum values
    }
}