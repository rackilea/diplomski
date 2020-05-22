Observable.just(1)
.map(v -> {
    if (api.isVip()) {
       if (api.pendingCancel()) {
           return 1;
       }
       return 2;
    }
    return 3;
})
.subscribeOn(Schedulers.io())
.observeOn(AndroidSchedulers.mainThread())
.subscribe(v -> {
    if (v == 1) {
       YourVipIsAboutToCancelActivity.start();
    } else
    if (v == 2) {
       CancelVipActivity.start();
    } else {
       JoinVipActivity.start();
    }
});