PublishSubject<Object> subject = PublishSubject.create();
// observer1 will receive all onNext and onCompleted events
subject.subscribe(observer1);
subject.onNext("one");
subject.onNext("two");
// observer2 will only receive "three" and onCompleted
subject.subscribe(observer2);
subject.onNext("three");
subject.onCompleted();