private static <T, R> Optional<R> findCommon(T[] data, Function<? super T, ? extends R> getterMethod) {
    R onlyValue = null;
    for (T obj : data) {
        R value = getterMethod.apply(obj);
        if (value == null)
            return Optional.empty();
        if (onlyValue == null)
            onlyValue = value;
        else if (! value.equals(onlyValue))
            return Optional.empty();
    }
    return Optional.ofNullable(onlyValue);
}