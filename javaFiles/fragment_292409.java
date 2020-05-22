public static <T extends Cacheable> MyOwnCustomGeneric<T> createMyOwnCustomGeneric(Class<T> type) {
    return new MyOwnCustomGeneric<T>();
}

// ...
IMyOwnCustomGeneric foo = createMyOwnCustomGeneric(instance.getClass());