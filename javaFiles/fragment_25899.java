groupContactSubscription = realm.where(GroupContacts.class).findAll().asObservable()
         .observeOn(Schedulers.io())
         .switchMap(() -> 
             Observable.fromCallable(() -> {
                try(Realm realm = Realm.getDefaultInstance()) {
                    RealmRefresh.refreshRealm(realm); // from http://stackoverflow.com/a/38839808/2413303
                    RealmResults<GroupContact> groupContacts = realm.where(GroupContact.class)
                                                                 .equalTo(MODEL_ID, mGroupId)
                                                                 .findAll();
                    List<Contact> contacts = new ArrayList<>();
                    //Transform each GroupContact
                    for(int i = 0; i < groupContacts.size(); ++i) {
                        contacts.add(transformGroupContact(groupContacts.get(i));
                    }
                    return contacts;                        
                }
            })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Action1<List<Contact>>() {
                @Override
                public void call(List<Contact> contacts) {
                    // Deal with transformed objects
                }
            });