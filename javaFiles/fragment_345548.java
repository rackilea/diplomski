Map<S,Map<D,K>> src = ...;
Map<D,Map<S,K>> dest = src.entrySet().stream() // Stream<Map.Entry<S,Map<D,K>>>
    .flatMap(eO -> {
        final S curS = eO.getKey();
        return eO.getValue().entrySet().stream() // Stream<Map.Entry<D,K>>
            .map(eI -> new Object[] { curS, eI.getKey(), eI.getValue() });
            // Stream<Object[]{S,D,K}> for this S
    }) // Stream<Object[]{S,D,K}> for all S
    .collect(Collectors.groupingBy(
            arr -> (D)arr[1], // What to group by in the outer level
            Collectors.toMap( // What to do with the inner level values for each D
                arr -> (S)arr[0], // Keys for the inner map
                arr -> (K)arr[2]  // Values for the inner map
    )));