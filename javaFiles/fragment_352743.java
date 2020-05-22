new Observable.OnSubscribe() {
            @Override
            public void call(Subscriber subscriber) {
                subscriber.onNext(longRunningOperation());
                subscriber.onCompleted();
            }
        });