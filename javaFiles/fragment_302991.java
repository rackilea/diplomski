public class SQLMultiton{
    private static final Map<Object, SQLMultiton> instances = new HashMap<Object, SQLMultiton>();

    private SQLMultiton() {
        // no explicit implementation
    }

    public static synchronized SQLMultiton getInstance(SQLConfiguration key) {

        // Our "per key" singleton
        SQLMultiton instance = instances.get(key);

        if (instance == null) {
            // Lazily create instance
            instance = new SQLMultiton();
            instance.init();  
            // Add it to map   
            instances.put(key, instance);
        }

        return instance;
    }

    // other fields and methods ...
}