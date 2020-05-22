mAdapterObservable =
mViewPeriodSubject
    .flatMap(period -> MyRetrofitAPI.getService().fetchData(period).onErrorResumeNext(e -> Observable.empty()) // this might fail
    .flatMap(Observable::from)
    .map(MyItem::modifyItem)
    .toList()
    .map(obj -> new MyAdapter(obj));