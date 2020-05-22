public final class Singleton {
    private Singleton() {}

    public static Singleton getInstance() {
        return Holder.instance;
    }

    public static void sayHello() {
        System.out.println("Hello!");
    }

    private static class Holder {
        private static final Singleton instance = new Singleton();
    }
}