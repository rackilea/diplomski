public class MySingleton {
    private static Integer instance = new Integer(42);

    public static Integer getInstance() {
        return instance;
    }
}