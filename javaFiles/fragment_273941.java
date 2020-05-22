Observable<Long> idObservable;
if (fitClass.getAid() == null) {
    idObservable = service.getReservedClasses(FitHelper.clientId)
        .map({ reservedClasses ->
            /* Get the Id and do stuff with it */
            return fitClass.getAid();
        });
} else {
    idObservable = Observable.just(fitClass.getAid());
}

idObservable.flatMap({ aid -> service.unbookClass(aid) })
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe(/* TODO */);