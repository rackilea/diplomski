Observable obs1 = Observable.fromCallable(// Callable 1);
Observable obs2 = Observable.fromCallable(// Callable 2);
Observable obs3 = Observable.fromCallable(// Callable 3);

Observable.zip(obs1, obs2, obs3, (o1, o2, o3) -> // something)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(o -> {
               // on success
        });