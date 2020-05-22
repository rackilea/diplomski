private <T> void apply(
        OperationContainer container,
        Class<T> keyType,
        Object argument
) {
    T castArgument = keyType.cast(argument);
    Operation<T> operation = container.get(keyType);
    operation.apply(castArgument);
}

public void test() {
    OperationContainer container = new OperationContainer();
    container.put(Integer.class, new Operation<Integer>());
    container.get(Integer.class).apply(new Integer(1234));

    Class<?> keyType = container.getSomeStoredKey();

    apply(container, keyType, new Integer(5678));
}