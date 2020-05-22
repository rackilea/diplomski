for(final Airport air : airps) {
    realm.executeTransactionAsync(new Realm.Transaction() {
        @Override
        public void execute(Realm mRealm) {
            AirportR airport = mRealm.createObject(AirportR.class);
            airport.setId(air.getId());
        }
    }, new Realm.Transaction.OnSuccess() {
        @Override
        public void onSuccess() {
            Log.wtf("ok", "ok");
        }
    }, new Realm.Transaction.OnError() {
        @Override
        public void onError(Throwable error) {
            Log.e("ok", "non vaaa");
        }
    });
}