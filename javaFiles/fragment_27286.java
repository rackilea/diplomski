public class Singleton {

    private static Singleton obj = null;
    private static final Object syncRoot = new Object();

    Singleton() {
    }

    public static Singleton getInstance() {
        synchronized(syncRoot){
            if (obj == null) {
                obj = new Singleton();
            }
        }
        return obj;
    }
}