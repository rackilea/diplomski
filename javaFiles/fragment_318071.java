PublishSubject<SQSMessage<String>> ps = PublishSubject.create()
ps.publish();
ps.subscribe(m -> System.err.println(m));

flowable.parallel()
    .runOn(Schedulers.io())
    .map(item -> {   
        // This map sends the object to my listeners on PublishSubject
        ps.onNext(item);
       return item;
    })
    .sequential()
    // This map does the post processing after
    // the object was sent to the listeners
    .map(s -> {//do post process stuff})
    .subscribe();