return a2b(a)
        .subscribeOn(Schedulers.io())
        .publish( bObservable -> 
               Observable.zip( bObservable.map( b -> this::b2c ),
                               bObservable.map( b -> this::b2d ),
                               (c, d) -> combine( c, d ) )
        .subscribe( ... );