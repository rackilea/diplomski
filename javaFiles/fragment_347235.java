class Foo {
    static {
        System.out.println("Foo initializing");
    }
}

public class Test {
    public static void main(String [] args) throws Exception {
        Class.forName("Foo");
    }
}