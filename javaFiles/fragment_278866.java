Flux.<Integer> create(e -> {
   log.info("create");
   e.next(2);
})
   .startWith(1)
   .switchMap(v -> Flux.interval(Duration.ofSeconds(v)))
   .subscribe(e -> log.info("subscribe: {}", e));