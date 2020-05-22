private Flux<String> fetchAll() {
        return Flux.range(0, 50)
                .map(i -> Integer.toString(i))
                .flatMap(this::fetch, 4);

    }

    private Mono<String> fetch(String a) {
        return Mono.create(em ->
                scheduledExecutorService.schedule(() -> em.success(a + " result"),
                        10 + random.nextInt(50), TimeUnit.MILLISECONDS)
        );
    }