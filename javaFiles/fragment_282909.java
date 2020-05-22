disposables.add(
    modelManager.apiCall()
        .subscribeOn(Schedulers.io())
        .doOnSuccess((apiResponse) -> {
            modelManager.storeInDatabase(apiResponse)
        })
        .flatMap((apiResponse) -> {
            modelManager.loadFromDatabase()
        })
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe((data) -> {
            view.showData(data);
        })
);