class Foo {
    public static final char a = 'a';
    // etc.

    public static void main(String[] args) {
        method(a);  // equivalent to method('a')
    }
}