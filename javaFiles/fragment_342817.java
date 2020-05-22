StepVerifier.create(dataFlux)
        .recordWith(ArrayList::new)
        .thenConsumeWhile(x -> true)  // Predicate on elements
        .consumeRecordedWith(matches ->
            matches.forEach(v -> checkValue(v)))
        .verifyComplete();