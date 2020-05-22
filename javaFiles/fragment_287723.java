public class InitializationExample {
    public static void main(String[] args) {
        System.out.println("demonstrating lazy initialization");
        System.out.println("accessing non-enum singleton");
        Object o = Singleton.INSTANCE;
        System.out.println("accessing the enum singleton");
        Object p = SingletonEnum.INSTANCE;
        System.out.println("q.e.d.");
    }
}
public enum SingletonEnum {
    INSTANCE;

    private SingletonEnum() {
        System.out.println("SingletonEnum initialized");
    }
}
public class Singleton {
    public static final Singleton INSTANCE = new Singleton();

    private Singleton() {
        System.out.println("Singleton initialized");
    }
}