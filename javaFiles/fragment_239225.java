class B extends A {
    private final String greeting;
    public B() {
        greeting = "Hello";
    }
    void test() {
        System.out.println(greeting + " from B");
    }
}