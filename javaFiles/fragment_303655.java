Field f = ...;
Class<?> typeClass = f.getType();
withClassCapture(typeClass);

private <T> void withClassCapture(Class<T> klazz) {
    BClass<T> instance = new BClass<T>();
    // ... do your thing
}