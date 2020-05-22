public class Foo {
    int x;
    public int foo(int x) {
        // returns x from argument, not the field of the class
        return x;
    }
}