public class MyDecorator {


    private MyInterfaceWithManyMethods object;

    public MyDecorator(MyInterfaceWithManyMethods object) {
        this.object = object;
    }

    public void method1() {
        object.method1();
    }

    public void method2() {
        object.method2();
    }

    public void method3() {
        object.method3();
    }

}