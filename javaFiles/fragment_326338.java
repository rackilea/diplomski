@Test
public void delaySteps() {
    long start = System.currentTimeMillis();
    Subscription subscription =
            Observable.zip(Observable.from(Arrays.asList(1, 2, 3)), Observable.interval(200, TimeUnit.MILLISECONDS),
                           (i, t) -> i)
                    .subscribe(n -> System.out.println("time:" + (System.currentTimeMillis() - start)));
    new TestSubscriber((Observer) subscription).awaitTerminalEvent(3000, TimeUnit.MILLISECONDS);
}