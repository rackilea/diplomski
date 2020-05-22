public interface ValueProvider<T> {
    public T getValue();
}

Class<? extends ValueProvider<Integer>> dynamicType = new ByteBuddy()
    .subclass(clazz)
    .name("ConstantIntProvider")
    .method(named("getValue"))
    .intercept(FixedValue.value(100))
    // etc.