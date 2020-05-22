public final class MySingleton {
    private static volatile MySingleton instance;

    private MySingleton() {
        // TODO: Initialize
        // ...
    }

    /**
      * Get the only instance of this class.
      *
      * @return the single instance.
      */
    public static MySingleton getInstance() {
        if (instance == null) {
            synchronized (MySingleton.class) {
                if (instance == null) {
                    instance = new MySingleton();
                }
            }
        }
        return instance;
    }
}