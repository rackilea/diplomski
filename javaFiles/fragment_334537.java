int numberOfSubscribers = 0;

...

public Observable<T> expose(){
    return subject.asObservable()
        .doOnSubscribe(()-> numberOfSubscribers++)
        .doOnDispose(()-> {
            numberOfSubscribers--;
            if (numberOfSubscribers == 0){
              //remove the object
             }
        });