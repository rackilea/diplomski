List<Mono<String>> listOfMonosWithString = Arrays.asList(Mono.just("a"), Mono.just("b"), Mono.just("c"));
    Flux<String> mergedMonos = Flux.fromIterable(listOfMonosWithString)
            .flatMapSequential(Function.identity());

    mergedMonos
            .reduce(String::concat)
            .doOnNext(System.out::println)
            .subscribe();