default <R> Procedure<S, R> andThen(BiFunction<S, T, R> after) {
    Objects.requireNonNull(after);
    return (param) -> {
        ValueContainer<T> intermediateValue = procede(param);
        if (intermediateValue.isTerminated())
            return ValueContainer.<R>terminated();
        R returnValue = after.apply(param, intermediateValue.getValue());
        return ValueContainer.of(returnValue);
    };
}