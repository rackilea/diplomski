interface NotEvenRemotelyFunctional extends Supplier<String> {
    default String get() { return ""; }
    void foo();
    void bar();
}
static class SomeOrdinaryClass implements NotEvenRemotelyFunctional {
    public void foo() { System.exit(0); }
    public void bar() { System.out.println("hello"); }
}