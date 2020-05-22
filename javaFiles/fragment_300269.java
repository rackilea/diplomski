// for 10 sec 
    disposableLiveTracking = Observable.interval(0, 10, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(v -> call api here, throwable -> throwable.printStackTrace());

/for 3 sec
    disposableLiveTracking = Observable.interval(0, 3, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(v -> call api here, throwable -> throwable.printStackTrace())