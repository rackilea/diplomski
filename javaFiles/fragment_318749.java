@Test
    void test() {
        Mono<String> monoWithContent =
            Mono.just("Content")
            .map(element -> exceptionThrower());

        // TEST 1
        StepVerifier.create(monoWithContent)
            .expectError()
            .verify();

        Mono<String> monoWithoutContent =
            Mono.empty()
            .map(element -> exceptionThrower());

        // TEST 2
        StepVerifier.create(monoWithoutContent)
            .expectError()
            .verify();
    }

    String exceptionThrower() {
        throw new RuntimeException();
    }