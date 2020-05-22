class Test {

    /* ... */

    Test(Api api, SchedulerProvider schedulerProvider) {
        mApi = api;
        mSchedulerProvider = schedulerProvider;
    }

    void go() {
        Observable.zip(
            mApi.webCall(),
            mApi.webCall2(),
            new Func2<String, String, Pair<String, String>>() {
                @Override
                public Pair<String, String> call(String s, String s2) {
                    return new Pair(s, s2);
                }
            }
      )
            .subscribeOn(mSchedulerProvider.io())
            .observeOn(mSchedulerProvider.mainThread())
            .subscribe(new Action1<Pair<String, String>>() {
                @Override
                public void call(Pair<String, String> pair) {
                    mApi.webCall3(pair.first, pair.second);
                }
            });
    }
}