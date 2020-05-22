Mono<Long> clock = Mono.defer(() -> Mono.just(System.currentTimeMillis()));
//time == t0

Thread.sleep(10_000);
//time == t10
clock.block(); //invoked currentTimeMillis() here and returns t10

Thread.sleep(7_000);
//time == t17
clock.block(); //invoke currentTimeMillis() once again here and returns t17