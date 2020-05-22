public class Gingleton {

    // volatile
    private static volatile Gingleton INSTANCE = null;

    public static Gingleton getInstance()
    {
        if ( INSTANCE == null )
        {
            synchronized (Gingleton.class) {  // Synchronized
                if ( INSTANCE == null )
                {
                    INSTANCE = new Gingleton();
                }
            }
        }
        return INSTANCE;
    }

    private Gingleton() {
    }
}