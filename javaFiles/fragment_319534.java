List<Map<String, Pair<UUID, Long>>> collect = docs.map(doc -> {
    UUID id = UUID.randomUUID();
    return doc.collect(groupingBy(
        identity(),
    //  v--- adapting Collector<?,?,Long> to Collector<?,?,Pair>    
        collectingAndThen(counting(), n -> Pair.of(id, n))
    ));
}).collect(Collectors.toList());