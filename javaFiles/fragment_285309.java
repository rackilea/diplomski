mRealm=Realm.getDefaultInstance();
mRealm.executeTransaction(new Realm.Transaction() {
    @Override
    public void execute(Realm realm) {
        Category wisdom = realm.where(Categories.class).equalTo("category", "wisdom").findFirst();
        if(wisdom == null) {
            wisdom = realm.createObject(Categories.class);
            wisdom.setCategory("wisdom");
        }
        //more code
    }
});