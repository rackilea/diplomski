Flowable<RealmResult<RealmUser> result =
    realm.where(RealmUser.class)
         .findAllAsync()
         .asFlowable()
         .subscribeOn(AndroidSchedulers.mainThread())
         .unsubscribeOn(AndroidSchedulers.mainThread())
         .filter(RealmResults::isLoaded)
         .observeOn(Schedulers.from(singleThreadedExecutor))
         .map((ignored) -> {
             RealmConfiguration configuration = realm.getConfiguration();
             try(Realm realm = Realm.getInstance(configuration)) {
                 RealmResults<RealmUser> results = realm.where(RealmUser.class).findAll();
                 return mapToUsersList(results);
             }
         })
         .observeOn(AndroidSchedulers.mainThread())
         .subscribe((users) -> { ...