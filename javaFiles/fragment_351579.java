val observable: Observable<LocalDateTime> = Observable.create { emitter ->
    val timer = Timer()
    timer.schedule(timerTask {
        if (emitter.isDisposed) {//<-- cancel emmitting items if disposed
            timer.cancel()
        } else {
            emitter.onNext(LocalDateTime.now())
        }
    }, 0, 1000)

}
disposable = observable.share().subscribe { t ->
    System.out.println(" Hello World! $t");
    disposable?.dispose()//<-- here calling dispose() causes observable to stop emitting items
}