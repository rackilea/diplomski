source
    .compose(onTimeoutKeepAlive(
         10, TimeUnit.SECONDS, Schedulers.computation(),
         Notification.createOnError(new TimeoutException())
    ))
    .subscribe(/* ... */);