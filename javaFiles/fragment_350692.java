ledStream
        .doOnNext{
            ledSubject.onNext(it)
        }
        .debounce(COUNTDOWN_S, TimeUnit.SECONDS)
        .subscribe{
            ledSubject.onNext(LedEvent.LedOff)
        }