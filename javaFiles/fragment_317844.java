private Observable<List<User>> createResults() {
    return Observable.create((ObservableOnSubscribe<List<User>>) emitter -> {
        Realm realm = Realm.getDefaultInstance();
        final RealmResults<RealmUser> results = realm.where(RealmUser.class).findAllAsync();

        final RealmChangeListener<RealmResults<RealmUser>> realmChangeListener = element -> {
            if(element.isLoaded() && !emitter.isDisposed()) {
                List<User> users = mapFrom(element);
                if(!emitter.isDisposed()) {
                    emitter.onNext(users);
                }
            }
        };
        emitter.setDisposable(Disposables.fromAction(() -> {
            if(results.isValid()) {
                results.removeChangeListener(realmChangeListener);
            }
            realm.close();
        }));
        results.addChangeListener(realmChangeListener);
    }).subscribeOn(looperScheduler.getScheduler()).unsubscribeOn(looperScheduler.getScheduler());
}