resourceNode.fields().forEachRemaining(
    entry -> resourceNode.set(
        entry.getKey(),
        func(entry.getValue())
    )
);