// only accessed by methods which check the keys and values are the right type.
final Map<Class, List<Class>> map = new LinkedHashMap<Class, List<Class>>();

public <T, S extends T> void add(Class<T> key, Class<S> value) {
    List<Class> list = map.get(key);
    if (list == null)
        map.put(key, list = new ArrayList<Class>());
    list.add(value);
}

public <T, S extends T> List<Class<S>>get(Class<T> key) {
    return (List<Class<S>>) map.get(key);
}

public <T, S extends T> boolean contains(Class<T> key, Class<S> value) {
    List<Class> list = map.get(key);
    if (list == null) return false;
    return list.contains(value);
}

public static void main(String... args) {
    Main m = new Main();
    m.add(Number.class, Integer.class); // compiles
    m.add(Number.class, String.class); // does not compile.
}