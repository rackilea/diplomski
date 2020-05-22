public class MySingleton {
    private static class Holder {
        static final MySingleton INSTANCE = new MySingleton ();
    }

    public static MySingleton getInstance() {
        return Holder.INSTANCE;
    }
    // rest of class omitted
}