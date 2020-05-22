public List<Model> getModelList() {
    List<Model> list = new ArrayList<>();
    Realm realm;
    try {
        realm = Realm.getDefaultInstance();
        RealmResults<Model> results = realm
                .where(Model.class)
                .findAll();
        list.addAll(realm.copyFromRealm(results));
    } finally {
        if (realm != null) {
            realm.close();
        }
    }
    return list;
}