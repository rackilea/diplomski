Observable.zip(
        Observable.from(spots),
        Observable.interval(SYNC_TICK, TimeUnit.MILLISECONDS),
        (obs, timer) -> obs)
        .subscribeOn(scheduler)
        .observeOn(scheduler)
        .unsubscribeOn(scheduler)
        .flatMap(this::buildObservable)
        .subscribe(
            new EventSubscriber(
                lunaEventService,
                solarService,
                swellService,
                conditionsService,
                synchronisationIntentProvider.get(),
                errorHandlerService,
                localBroadcastManager,
                TRENDING_LENGTH_DAYS
            )
        );