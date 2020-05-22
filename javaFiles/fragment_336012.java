sortObservable.flatMap(new Func1<SortBy, Observable<Movie[]>>() {

    @Override
    public Observable<Movie[]> call(SortBy sortBy) {
        switch (sortBy) {
            case POPULAR:
                return Observable.fromCallable(() -> MovieDB.getPopular()).subscribeOn(Schedulers.io());
            case TOP_RATED:
                return Observable.fromCallable(() -> MovieDB.getTopRated()).subscribeOn(Schedulers.io());
            default:
                return Observable.fromCallable(() -> new Movie[0]).subscribeOn(Schedulers.io());
        }
    }
})
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Action1<Movie[]>() {
            @Override
            public void call(Movie[] movies) {
                imageAdapter.loadData(movies);
            }
        });