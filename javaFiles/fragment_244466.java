objectFlux.flatMap(o ->
    Mono.just(o)
        .filterWhen(languageRepository.exists(...)) //native
        .switchIfEmpty(Mono.error(new RuntimeException("Native language doesn't exist"))
        .filterWhen(languageRepository.exists(...)) //target
        .switchIfEmpty(Mono.error(new RuntimeException("Target language doesn't exist"))
    )
    .flatMap(wordSetRepository::save);