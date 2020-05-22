Observable<String> obs1 = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    subscriber.onNext(callApi1());
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        })
        .timeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
        .retryWhen(new RetryWithDelay(20, 3000))            
        .subscribeOn(Schedulers.io());

Observable<String> obs2 = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    subscriber.onNext(callApi2());
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        })
        .timeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
        .retryWhen(new RetryWithDelay(20, 3000))            
        .subscribeOn(Schedulers.io());

Observable<String> chained = Observable.concat(obs1,obs2);