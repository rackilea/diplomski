public class ProviderSuppliers {
    @Producer
    @Named("fooA")
    public static Provider<Foo> getFooA() {
        return //create Provider for FooA
    }
    @Producer
    @Named("fooB")
    public static Provider<Foo> getFooB() {
        return //create Provider for FooB
    }
    @Producer
    @Named("fooC")
    public static Provider<Foo> getFooC() {
        return //create Provider for FooC
    }
}