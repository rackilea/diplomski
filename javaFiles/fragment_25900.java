Subscription contacts = realm.where(Contact.class)
                                      .equalTo("groupContact.modelId", mGroupId)
                                      .findAllAsync()
                                      .asObservable()
                                      .filter(RealmResults::isLoaded)
                                      .filter(RealmResults::isValid)
                                      .subscribe(...);