Mono<Optional<Dog>> dogMono = Mono.just(Optional.empty());
if(condition1) {
    dogMono = dogApiClient.getDog().map(Optional::of);
}

Mono<Optional<Cat>> catMono = Mono.just(Optional.empty());
if(condition2) {
    catMono = catApiClient.getCat().map(Optional::of);
}

Mono<Optional<Horse>> horseMono = Mono.just(Optional.empty());
if(condition3) {
    horseMono = horseApiClient.getHorse().map(Optional::of);
}

Mono.zip(dogMono, catMono, horseMono)
    .map(this::mapToAnimals);

private Output mapToAnimals(Tuple3<Optional<Dog>, Optional<Cat>, Optional<Horse>> tuple3)
{
    Dog dog = tuple3.getT1().orElse(null);
    Cat cat = tuple3.getT2().orElse(null);
    Horse horse = tuple3.getT3().orElse(null);

    return new Output(dog, cat, horse);
}