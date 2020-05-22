Observable<List<Countries>> backendObservable = mCountriesApi.getCountries()
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .doOnNext(list -> Log.d(TAG, "doOnNext"));
        .doAfterNext(list -> Log.d(TAG, "doAfterNext"));
        .doOnComplete(() -> Log.d(TAG, "doOnComplete"));
        .subscribe(...);