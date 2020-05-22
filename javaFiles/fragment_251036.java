@Override
public Flowable<RealmResults<Stores>> searchStores(String searchString) {
searchNetwork(searchString);

 try (Realm realm = Realm.getDefaultInstance()) {

    RealmQuery<Stores> query = realm.where(Stores.class).like("name", searchString, 
    Case.INSENSITIVE);
    return query
            .findAll()
            .asFlowable()
            .onBackpressureLatest()
            .flatMap(realmResultsCollectionChange -> 
                      query.findAll().asFlowable());

}
}