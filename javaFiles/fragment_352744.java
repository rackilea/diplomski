new Observable.OnSubscribe<Subscriber>() {
            @Override
            public void call(Subscriber subscriber) {
                subscriber.onNext(longRunningOperation());
                subscriber.onCompleted();
            }
        });