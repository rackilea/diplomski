@Test
public void testFlux() {
    Flux<String> oneString = Flux.just("1");

    oneString
        .flatMap(s -> testMono(s))
        .collectList()
        .subscribe(integers -> System.out.println("elements:" + integers));       

}

private Mono<Integer> testMono(String s) {
    return Mono.just(Integer.valueOf(s + "0"));
}