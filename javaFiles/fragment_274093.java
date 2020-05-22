class Foo {
    static int x = 0;
    static {
        x = 10;
    }

    static int getX() {
        return x;
    }
}

public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println(Foo.getX()); // Prints 10
    }
}