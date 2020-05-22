Observable.from(Lists.newArrayList(1, 2, 3, 4, 5))
        .flatMap( number -> Observable.defer( numberToString() )
                              .subscribeOn( Schedulers.computation() ) )
        .observeOn(Schedulers.computation())
        .map(numberToString())
        .subscribe(printResult());