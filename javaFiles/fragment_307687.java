public class TestLambda {
    public static void main(String[] args) {
        xxx();
    }
    static void xxx() {
        Functional1 f  = () -> {
            Object o = new Object() { };
            return new A();
        };
    }
    static class A { }
    static interface Functional1 { A func(); }
}