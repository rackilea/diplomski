public class MyClass {
    public MyClass() {
        System.out.println("1 - Constructor with no parameters");
    }

    {
        System.out.println("2 - Initializer block");
    }

    public MyClass(int i) {
        this();
        System.out.println("3 - Constructor with parameters");
    }

    static {
        System.out.println("4 - Static initalizer block");
    }

    public static void main(String... args) {
        System.out.println("5 - Main method");
        new MyClass(0);
    }
}