realm.executeTransactionAsync(new Realm.Transaction() {
    @Override
    public void execute(Realm realm) {
        AirportR airport = new AirportR();
        for(final Airport air : airps) {
            airport.setId(air.getId());
            realm.insertOrUpdate(airport);
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