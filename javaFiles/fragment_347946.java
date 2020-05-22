public class B {
    public static final B NULL = new B() {
        public void doSomething() {
        }
    };

    public static B fromA(A a) {
        B b = a.getB();
        return b == null ? NULL : b;
    }

    public void doSomething() {
        ...
    }
}