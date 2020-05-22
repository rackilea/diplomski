@Test
public void testMergeOperator() {
    TestObserver<String> observer = new TestObserver<>();

    Observable<String> foo = Observable.just("FOO");
    Observable<String> bar = Observable.timer(2, TimeUnit.SECONDS).map(v -> "BAR");

    foo.publish(first -> Observable.merge(first, bar.takeUntil(first))
            .firstOrError()
            .toObservable())
            .subscribe(observer);

    assertEquals(1, observer.valueCount());
    assertEquals("FOO", observer.values().get(0));
}