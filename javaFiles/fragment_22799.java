resultTable = immutableTable.cellSet().parallelStream()
    .map(cell -> processAndGetOptionalResult(cell))
    .collect(Collector.of(
            ImmutableTable.Builder::new,
            (b,o) -> o.ifPresent(b::put),
            (l, r) -> l.putAll(r.build()),
            ImmutableTable.Builder<String,String,String>::build)
    );