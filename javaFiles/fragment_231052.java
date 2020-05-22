abstract class InterfaceDecorator implements Interface {
    protected InterfaceDecorator decoratedInterface;

    public InterfaceDecorator (Interface decoratedInterface) {
        this.decoratedInterface = decoratedInterface;
    }

    void method1() {
        decoratedInterface.method1()
    }

    void method2() {
        decoratedInterface.method2()
    }
}