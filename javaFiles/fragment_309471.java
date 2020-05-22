Mono.just(5)
  .doOnNext(i -> logger.info(i + ""))     // <-- is called and prints '5'
  .flatMap(i -> Mono.empty())
  .doOnNext(i -> logger.info(i + ""))     // <-- is NOT called
  .doOnSuccess(i -> logger.info("Done"))  // <-- is called and prints 'Done' (i is null)
  .block();