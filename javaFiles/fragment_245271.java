Flux<Integer> flux = Flux.concat(Mono.just(1).delayElement(Duration.ofMillis(100)),
        Mono.just(2).delayElement(Duration.ofMillis(500))).log();

Mono<String> mono = Mono.just("a").delayElement(Duration.ofMillis(50)).log();

List<String> list = flux.join(mono, (v1) -> Flux.never(), (v2) -> Flux.never(), (x, y) -> {
    return x + y;
}).collectList().block();

System.out.println(list);