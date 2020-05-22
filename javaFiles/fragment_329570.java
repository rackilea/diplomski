public class Foo {
    private  Foo foo = new Foo();//Line 4

    public Foo() {
        System.out.println("initializing");
    }

    public static void main(String... args) {
        Foo foo = new Foo();
    }
}