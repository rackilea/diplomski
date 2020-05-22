@Test
    public void testHotChocolate(){
        Flux<String> chocolateSource =
                client.get()
                        .uri("/stream/chocolate")
                        .retrieve()
                        .bodyToFlux(String.class)
                        .doOnNext(System.out::println);
        chocolateSource.blockLast();
    }