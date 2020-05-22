realm.executeTransaction(new Realm.Transaction() {
    @Override
    public void execute(Realm realm) {
        RealmResults<Pubs> results = query.findAll();
        for(Pub p : results) {
            p.deleted = 1;
        }
    }
});