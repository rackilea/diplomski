try (First first = resource.get()) {
    first.connect(...);
    try (Second second = first.get()) {
        // ...
    }
}