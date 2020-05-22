public final class ClassSingleton {

    private static volatile ClassSingleton INSTANCE;
    private String info = "Initial info class";

    private ClassSingleton() {        
    }

    private static final Object lock = new Object();

    public static ClassSingleton getInstance() {
        if(INSTANCE == null) {
            synchronized(lock) {
                if(INSTANCE == null) {
                    INSTANCE = new ClassSingleton();
                }
            }
        }

        return INSTANCE;
    }

    // getters and setters
}