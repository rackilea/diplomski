public T build() {
    T value = instantiator.get();
    instanceModifiers.forEach(modifier -> modifier.accept(value));
    verifyPredicates(value);
    instanceModifiers.clear();
    return value;
}

private void verifyPredicates(T value) {
    List<Predicate<T>> violated = predicates.stream()
            .filter(e -> !e.test(value)).collect(Collectors.toList());
    if (!violated.isEmpty()) {
        throw new IllegalStateException(value.toString()
                + " violates predicates " + violated);
    }
}