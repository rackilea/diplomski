class MyClass<F extends Field, G extends OtherClass<F>> {

    public MyClass() {}
    public MyClass(G dummy) {}

    public static <T> T infer() {
        return null;
    }
}