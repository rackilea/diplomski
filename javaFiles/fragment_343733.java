PublishSubject<String> subject = PublishSubject.<String>create()

Observable<String> source = subject
   .doOnNext( item ->  System.out.println("Do something with the item " + item) );

source.subscribe(System.out::println, Throwable::printStackTrace);

subject.onNext("1");