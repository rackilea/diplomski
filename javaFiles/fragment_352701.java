@Test
void name3231() {
    Subject<String> subject = PublishSubject.create();
    Observable<String> observable = subject.scan("zero", (a, b) -> a + ", " + b);

    ConnectableObservable<String> observableMulticast = observable.publish();

    Disposable connect = observableMulticast.connect(); // must be disposed by hand

    TestObserver<String> test = observableMulticast.test();

    Disposable first = observableMulticast.subscribe(System.out::println); // "zero"
    subject.onNext("one"); // "zero, one"
    first.dispose();

    test.assertValues("zero, one");

    Disposable second = observableMulticast.subscribe(System.out::println); // "zero, one"
    subject.onNext("two"); // "zero, one, two"
    second.dispose();

    test.assertValues("zero, one", "zero, one, two");
}