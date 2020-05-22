MyClass x = new MyClass();

MyClass y = new MyClass() {
    @Override
    void interfaceMethod() {
        throw new UnsupportedOperationException();
    }
};