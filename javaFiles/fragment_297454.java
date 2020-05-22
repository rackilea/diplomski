Subscription subscriber = Observable.interval(0, 5, TimeUnit.MILLISECONDS)
                .map(i -> eventHandler.getProcessedEvents())
                .first(eventsProcessed -> eventsProcessed >= 10)
                .doOnNext(eventsProcessed -> eventHandler.initProcessedEvents())
                .doOnNext(eventsProcessed -> logger.info(null, "Total number of events processed:" + eventsProcessed))
                .subscribe(t -> resumeRequest(asyncResponse));