Observable<String> strings = Observable.from(Arrays.asList(5, 4, 7, 2, 1))
    //be efficient / parallel friendly but still retain order
    .concatMapEager(i -> 
        //Main's method has been converted to return an Observable
        retrieve(i)
        //retrieve will be executed in its own IO thread, so in parallel
        .subscribeOn(Schedulers.io())
    );