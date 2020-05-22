@Test
public void deferredConnect() throws InterruptedException {
    ConnectableFlux<Integer> connectableFlux = Flux.range(1, 10)
        .publish();
    AtomicInteger subCount = new AtomicInteger();

    Flux<Integer> deferredConnect = connectableFlux
        .doOnSubscribe(sub -> {
            int current = subCount.incrementAndGet();
            Schedulers.parallel().schedule(() -> {
                if (subCount.compareAndSet(current, -1)) {
                    connectableFlux.connect();
                }
            }, 1, TimeUnit.SECONDS);
        });

    deferredConnect.subscribe(v -> System.out.println("1: " + v));
    Thread.sleep(500);
    deferredConnect.subscribe(v -> System.out.println("2: " + v));
    Thread.sleep(400);
    deferredConnect.subscribe(v -> System.out.println("3: " + v));
    Thread.sleep(200);
    assertThat(subCount).hasNonNegativeValue();
    Thread.sleep(800);
    assertThat(subCount).hasNegativeValue();
}