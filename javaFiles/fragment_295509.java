PublishSubject<Integer> ps = PublishSubject.create();

Subject<Integer, Integer> subject = ps.toSerialized();

subject.subscribe(System.out::println);

subject.onNext(1);