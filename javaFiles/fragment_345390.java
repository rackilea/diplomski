List<FeedsListModel> eventFeedItems = Arrays.asList(new FeedsListModel(), new FeedsListModel());

Observable<FeedsListModel> feedsListModelObservable = Observable.fromIterable(eventFeedItems)
                    .flatMap(feedsListModel -> Observable.fromCallable(() -> calculation(feedsListModel))
                            .subscribeOn(Schedulers.computation())
);

feedsListModelObservable
        .toList()
        .observeOn(Schedulers.io())
        .subscribe(feedsListModels -> {
            // do UI stuff
});