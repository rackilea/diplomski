public class MyDecorator {

    private final MyObject object = new MyObject();

    public void method1() {
        object.method1();
    }

    public void method2() {
        object.method2();
    }

    public void method3() {
        object.method3();
    }

    private class MyObject implements MyInterfaceWithManyMethods {
        public void method1() {

        }

        public void method2() {

        }

        public void method3() {

        }
    }
}