public class A {
    interface Wtf { }

    static class B extends A implements Wtf { }

    public static void main(String[] args) {
        A a = new B();
        Wtf wtf = (Wtf) a;
    }
}