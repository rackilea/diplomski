directories = delayCache(Mono.fromCallable(provider::list))

...

public <T> Mono<T> delayCache(Mono<T> mono) {
    return mono.takeUntilOther(Mono.delay(Duration.ofSeconds(10)).cache())
            .switchIfEmpty(mono.cache(Duration.ofMinutes(15)));
}