public Flowable<List<ChatsModel>> getAllChatsData(Realm realm) {
    RealmQuery<ChatsModel> query = realm.where(ChatsModel.class);
    if(realm.isAutoRefresh()) {
        return query.findAllAsync().asFlowable().filter(RealmResults::isLoaded);
    } else {
        return Flowable.just(query.findAll());
    }
}