public enum EnumA implements MyInterface {
    ;

    private MyInterface impl = new MyInterfaceImpl();

    public void someMethod() {
        impl.someMethod();
    }

}