public void ingest(IV2GraphObject ingestable) {
    Class<? extends IV2GraphObject> ingestableClass = ingestable.getClass();
    helper(ingestableClass, ingestable);
}

private <T extends IV2GraphObject> void helper(Class<T> clazz, IV2GraphObject ingestableTemp) {
    T ingestable = clazz.cast(ingestableTemp);
    Handler<T> handler = handlers.get(ingestableClass);
    try {
        handler.handle(ingestable);
    // ...
}