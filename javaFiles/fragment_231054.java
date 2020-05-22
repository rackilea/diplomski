public static void main(String[] args) {
    Interface simpleInterface = new SimpleInterface();
    Interface decoratedInterface = new Method1DecoratedInterface (new SimpleInterface());

    // These two method1 calls will behave differently
    simpleInterface.method1();
    decoratedInterface.method1();
}