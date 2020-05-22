api.isVip()
.flatMap(b -> {
    if (b) {
        return api.pendingCancel().map(c -> c ? 1 : 2);
    }
    return Observable.just(3);
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