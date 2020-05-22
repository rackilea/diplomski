public void storePreferenceDao(int userID, String rank) {
    final PreferenceDao preferenceDao = new PreferenceDao();
    preferenceDao.setUserID(userID);
    preferenceDao.setRank(rank);
    runInTransaction(new Realm.Transaction() {
        @Override
        public void execute(Realm realm) {
            realm.copyToRealmOrUpdate(preferenceDao);
        }
    });
}