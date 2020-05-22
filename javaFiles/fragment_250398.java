class CountdownTimer {
    SerialDisposable disposable = new SerialDisposable();

    //...

    public void start() {
         disposable.set(
             Observable.intervalRange(0, startValue, 
                 1, timeUnit, AndroidSchedulers.mainThread())
             .subscribe(
                 tick -> onTick(startValue - tick)
                 error -> error.printStackTrace()
                 () -> onFinish()
             )
         );
    }

    public void cancel() {
         disposable.set(null);
    }
}