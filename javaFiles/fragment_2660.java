public interface MapFactory {
    <K, V> Map<K, V> newMap() throws Exception;
}

public enum HashMapFactory implements MapFactory {

    INSTANCE;

    @Override
    public <K, V> Map<K, V> newMap() {
        return new HashMap<K, V>();
    }
}

public static final class DynamicMapFactory implements MapFactory {

    private final Constructor<? extends Map<?, ?>> constructor;

    private DynamicMapFactory(Constructor<? extends Map<?, ?>> constructor) {
        this.constructor = constructor;
    }

    @Override
    //Impl note: these checked exceptions could also be wrapped in RuntimeException
    public <K, V> Map<K, V> newMap() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        @SuppressWarnings("unchecked") //this is okay because the default ctor will return an empty map
        final Map<K, V> withNarrowedTypes = (Map<K, V>)constructor.newInstance();
        return withNarrowedTypes;
    }

    public static DynamicMapFactory make(String className) throws ClassNotFoundException, NoSuchMethodException, SecurityException {

        @SuppressWarnings("unchecked") //Class<? extends Map> can safely be cast to Class<? extends Map<?, ?>>
        final Class<? extends Map<?, ?>> type =
                (Class<? extends Map<?, ?>>)Class.forName(className).asSubclass(Map.class);
        final Constructor<? extends Map<?, ?>> constructor = type.getDeclaredConstructor();

        return new DynamicMapFactory(constructor);
    }
}

public static void main(String[] args) throws Exception {

    Map<String, Integer> map1 = HashMapFactory.INSTANCE.newMap();
    Map<String, Integer> map2 = DynamicMapFactory.make("java.util.TreeMap").newMap();

    System.out.println(map1.getClass()); //class java.util.HashMap
    System.out.println(map2.getClass()); //class java.util.TreeMap
}