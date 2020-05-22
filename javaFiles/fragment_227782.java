Baz(String description) {
    // Can access static fields from before the enum
    first.add(description);

    // Can access static fields from _after_ the enum
    second.add(description);
}