class Foo {
    public static <T> T test(T obj) {
        return obj;
    }

    public static void main(String[] args) {
        String foo = Foo.test("foo");

        System.out.println(foo); // output: "foo"
        System.out.println(Foo.<String>test("Test")); // output: "Test"
        System.out.println(Foo.<Integer>test(16));    // output: "16"
    }
}