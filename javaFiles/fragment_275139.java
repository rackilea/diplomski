public static abstract class MyFactory {
    public abstract MyBase build();
}
public static class MyFactory1 extends MyFactory {
    @Override
    public Class1 build() {
        return new Class1();
    }
}
public static class MyFactory2 extends MyFactory {
    @Override
    public Class2 build() {
        return new Class2();
    }
}