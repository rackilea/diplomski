PublishSubject<Observable<T>> subject = 
    PublishSubject.create();
subject
    // protect against concurrent calls to subject (optional)
    .serialize()
    .concatMap(o -> 
      o.doOnCompleted(() -> System.out.println("inner completed")))
    .doOnNext(System.out::println)
    .doOnCompleted(() -> System.out.println("completed"))
    .subscribe(subscriber);

subject.onNext(Observable.just(t1));
subject.onNext(Observable.just(t2, t3));
subject.onCompleted();

  .