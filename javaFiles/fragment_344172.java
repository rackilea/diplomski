service
        //do login
        .loginUser()
        //side effect: save into Shared Preference
        .doOnNext( )
        //get SSO
        .flatMap()
        //do any other side effects
        .doOnNext()
        //do final network request
        .flatMap()
        //in case of error retry after 5 seconds
        .retryWhen(observable -> Observable.timer(5, TimeUnit.SECONDS))
        .subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())
        //update you UI
        .subscribe();