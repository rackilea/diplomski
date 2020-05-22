PublishSubject<Location> locationSource = PublishSubject.create();

        // bind to location source for receiving locations
        Observable<Integer> saveToDbTask =
        locationSource.asObservable()
                // this line switches execution into background thread from embedded thread pool
                .observeOn(Schedulers.computation())
                .map(location -> {
                    int result -> saveLocationToDb(location);
                    return result;
                });

        // subscribe to that task when you start
        Subscription subscription = saveToDbTask.subscribe(t -> {
            Log.i(LOG_TAG, "Result: " + t);
        });

        // unsubscribe when it is no longer needed
        if (null != subscription && !subscription.isUnsubscribed()){
            subscription.unsubscribe();
            subscription = null;
        }

        // tunnel location from your FusedLocationApi's callback to pipeline:
        Location loc = new Location(..);
        locationSource.onNext(loc);