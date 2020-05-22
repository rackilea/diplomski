final PublishSubject<String> subject = PublishSubject.create();

final Observable<String> o = 
    subject.doOnNext(...)
           .doOnError(...)
           .subscribe();