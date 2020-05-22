return realm.where(Event.class).findAllAsync()
        .asObservable() // <-- listens for changes in the Realm
// ...
        .doOnNext(new Action1<RealmResults<Event>>() {
            @Override
            public void call(RealmResults<Event> events) {
                service.getEvents() // <-- downloads data
                        .subscribeOn(Schedulers.io())
                        .subscribe(new Action1<List<Event>>() {