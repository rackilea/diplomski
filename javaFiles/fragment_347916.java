static <T> boolean notNull(Supplier<T> getter, Predicate<T> tester) {
    T x = getter.get();
    return x != null && tester.test(x);
}

    if (notNull(something::getThatObject, MyObject::someBooleanFunction)) {
        ...
    }