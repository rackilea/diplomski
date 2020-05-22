Observable.mergeDelayError(
            Observable.error(new RuntimeException())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribeOn(Schedulers.io()),
            Observable.just("Hello")
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribeOn(Schedulers.io())
        )
        .finallyDo(completeAction)
        .subscribe(successAction, errorAction);