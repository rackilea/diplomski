private <L extends List<Ps>> void doSomething(Map<String, L> map,
                                              Supplier<L> listCreator) {
    // ...

    map.put("stringValue", listCreator.get());
}