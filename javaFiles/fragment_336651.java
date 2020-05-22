Observable.fromIterable(arr)
        .subscribeOn(Schedulers.newThread())
                                                      // <------------------------
        .doOnSubscribe(new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {
                LogUtil.logD(TAG, Thread.currentThread().getName());
            }
        })
        .doOnNext(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                LogUtil.logD(TAG, Thread.currentThread().getName());
            }
        })
        .observeOn(AndroidSchedulers.mainThread())  // <--------------------------
        .subscribe(integer -> {
            LogUtil.logD(TAG, Thread.currentThread().getName());
        });