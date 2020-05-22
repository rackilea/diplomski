@Test
public void delayObservableList() {
    Observable.from(Arrays.asList(1, 2, 3, 4, 5))
            .concatMap(s -> Observable.just(s).delay(100, TimeUnit.MILLISECONDS))
            .subscribe(n -> System.out.println(n + " emitted"),
                       e -> {
                       },
                       () -> System.out.println("All emitted"));
    new TestSubscriber().awaitTerminalEvent(1000, TimeUnit.MILLISECONDS);

}