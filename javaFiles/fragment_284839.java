public static void main(String[] args) {
    Mono<String> mono = Mono.just("foo")
        .flatMap(value -> Mono.subscriberContext()
            .map(ctx -> value + context.getOrDefault("key", "UNKNOWN"))
        );
    Mono<String> monoWithCtxWrite = addContext(mono);

    mono.subscribe(System.out::println)
    monoWithCtxWrite.subscribe(System.out::println);
}