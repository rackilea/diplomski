class Method1InterfaceDecorator extends InterfaceDecorator {
    public Method1InterfaceDecorator(Interface decoratedInterface) {
        super(decoratedInterface);
    }

    void method1() {
        decoratedInterface.method1();
        method3()
    }

    void method3() {
        //method3 actions
    }
}