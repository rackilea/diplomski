public static <T extends RealmObject & IAction> void yorForEachMethod(Class<T> cls) {
    Realm realm = Realm.getDefaultInstance();
    RealmResults realmObjects = realm.where(cls).findAll();
    realm.beginTransaction();
    for (int i = realmObjects.size() - 1; i >= 0; i--) {
        if ... {
            Notification notification = new NotificationCompat.Builder(this)...;
            // you can evaluate implementation of action method from IAction interface
            ((IAction)realmObjects.get(i)).action();
            // or pass to assync task and work with IAction interface
            //StartMyAsyncTask().execute((IAction)realmObjects.get(i));
            // etc...

            // delete from DB
            realmObjects.get(i).removeFromRealm();
        }
    }
    realm.commitTransaction(); 
}