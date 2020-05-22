private List<SomeValue> createSomeValues(List<Anything> anyList) {
    return anyList //
            .stream() //
            .map(this::createSomeValue) //
            .collect(Collectors.toList());
}