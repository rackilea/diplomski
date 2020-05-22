public void storePreferenceDao(int userID, String rank) {
    final PreferenceDao preferenceDao = new PreferenceDao();
    preferenceDao.setUserID(userID);
    preferenceDao.setRank(rank);
    runTransaction(new Realm.Transaction() {
        @Override
        public void execute(Realm realm) {
            realm.copyToRealmOrUpdate(preferenceDao);
        }
    }, new Realm.Transaction.OnSuccess(){
        @Override
        public void onSuccess(){
            System.out.println("Data is stored successfully!");
        }
    }, new Realm.Transaction.OnError(){
        @Override
        public void onError(Throwable error){
            System.out.println("There is an error in storePreferenceDao()");
        }
    });
}