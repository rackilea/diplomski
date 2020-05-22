@GetMapping("/populations")
    public Mono<Integer> getPopulation() {
        return Flux.fromIterable(stateRepo.findAll())
                .map(s -> s.getPopulation())
                .reduce(0, (x1, x2) -> x1 + x2)
                .map(this::someFunction); // here you can handle the sum
    }