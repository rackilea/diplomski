public class Test {
    static void f(Object a, boolean b) {}
    static void f(int a, Object b) {}

    static void m(int a, boolean b) { f(a, b); } // ambiguous
}