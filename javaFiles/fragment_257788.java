static <T> Collector<T, ?, Optional<T>> singleOrEmpty() {
    return Collectors.collectingAndThen(
            Collectors.mapping(
                    Optional::of,
                    Collectors.reducing((a, b) -> Optional.empty())
            ),
            o -> o.orElseGet(Optional::empty)
    );
}

Stream.empty().collect(singleOrEmpty());   // Optional.empty
Stream.of(1).collect(singleOrEmpty());     // Optional[1]
Stream.of(1, 1).collect(singleOrEmpty());  // Optional.empty
Stream.of(1, 1).skip(1).collect(singleOrEmpty());  // Optional[1]