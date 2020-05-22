public class TopLevel {

    private static void foo() {
    }

    static class Nested1 {
        private static void bar() {
        }
    }

    static class Nested2 {
        private static void callFooBarFromNested() {
            foo();
            Nested1.bar();
        }
    }

    private static void callFooBarFromTopLevel() {
        foo();
        Nested1.bar();
    }
}