public class Test {

    public static void main(String args[]) {
        A a = new A();
        test(() -> a != null && a.get());
    }

    static void test(BooleanSupplier condition) {
        condition.getAsBoolean();
    }

    static class A {
        boolean get(){
            return true;
        }
    }
}