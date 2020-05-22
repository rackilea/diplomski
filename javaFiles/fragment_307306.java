Realm.init();
Realm realm = Realm.getDefaultInstance();
realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                       realm.copyToRealmOrUpdate(new AddressModel(//constructor);
                    }
                });