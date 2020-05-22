Mono<Long> clock = Mono.just(System.currentTimeMillis());
//time == t0

Thread.sleep(10_000);
//time == t10
clock.block(); //we use block for demonstration purposes, returns t0

Thread.sleep(7_000);
//time == t17
clock.block(); //we re-subscribe to clock, still returns t0