public class SingletonDemo {
    public static void main(String... ignored) {

        Singleton service = Singleton.getInstance();
        service.doSomething();
    }
}

public enum Singleton {
    INSTANCE;

    public static Singleton getInstance() { return INSTANCE; }

    public void doSomething() {
        System.out.println("Singleton.doSomething() called");
    }
}