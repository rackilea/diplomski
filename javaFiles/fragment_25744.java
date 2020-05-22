package de.scrum_master.app;

public class Application {
    public static void main(String[] args) throws Exception {
        foo();
        bar();
        zot();
        baz();
    }

    @NoLogging public static void foo() {}
    public static void bar() {}
    @NoLogging public static void zot() {}
    public static void baz() {}
}