public class InstanceTable {
    private final Map<Class,Object> table =
        new ConcurrentHashMap<Class,Object>();

    public <T> void put(Class<T> klass, T value)
        throws ClassCastException {
        table.put(klass.cast(value));
    }

    public <T> T get(Class<T> klass) {
        return klass.cast(table.get(klass))
    }

}