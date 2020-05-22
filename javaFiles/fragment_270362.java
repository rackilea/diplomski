.flatMapMany(refList -> {
        Mono.zip(fetchProducts(refList), fetchItems(refList), fetchWarehouses(refList)).cache()
            .flatMap(tuple -> Flux.fromIterable(refList).map(refId -> Tuples.of(refId, tuple)));
    .map(tuple -> {
        String refId = tuple.getT1();
        Tuple lookups = tuple.getT2();
    }
})