public Record removeIf(String key, Predicate<Record> condition) {

    AtomicReference<Record> existing = new AtomicReference<>();

    this.storage.computeIfPresent(key, (k, v) -> {
        existing.set(v);
        return condition.test(v) ? null : v;
    });

    return existing.get();
}