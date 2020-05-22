// obtain the results of a query

RealmResults<Dog> results = realm.where(Dog.class).findAll();

// All changes to data must happen in a transaction
realm.beginTransaction();

// Delete all matches
results.deleteAll();

realm.commitTransaction();