public class Example {
    public static void main(String[] args) throws Exception {
        new Bar();
    }
}

class Bar {
    static Foo foo = Foo.A;
    static Integer max = 42;

    enum Foo {
        A;

        Foo() {
            System.out.println(max);
        }
    }
}