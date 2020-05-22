private static class Holder {
    static Singleton instance = new Singleton();
}

public static Singleton getSingleton() { // Note: "synchronized" not needed
    return Holder.instance;
}