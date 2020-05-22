public class FooMultiton {
    private static final Map<Object, FooMultiton> instances = new HashMap<Object, FooMultiton>();

    private FooMultiton() {
        // no explicit implementation
    }

    public static synchronized FooMultiton getInstance(Object key) {

        // Our "per key" singleton
        FooMultiton instance = instances.get(key);

        if (instance == null) {
            // Lazily create instance
            instance = new FooMultiton();

            // Add it to map   
            instances.put(key, instance);
        }

        return instance;
    }

    // other fields and methods ...
}