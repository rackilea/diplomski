public class Singleton {
    private Object embInstance;

    private Singleton() { 
    }

    private static class SingletonHolder { 
            public static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
            return SingletonHolder.instance;
    }

    public synchronized Object getEmbInstance() {
        if (embInstance == null)
            embInstance = new Object();
        return embInstance;
    }

    public synchronized Object resetEmbInstance() {
        embInstance = null;
    }
}