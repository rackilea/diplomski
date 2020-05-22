.flatMap(new Func1<User, Observable<PutResult>>() {
    @Override
    public Observable<PutResult> call(User user) {
        if (user == null) return Observable.empty();

        //delete the session token and save
        user.removeSessionToken();
        return DatabaseModule.getStorIOSQLite()
                .put()
                .object(user)
                .prepare()
                .asRxObservable();
    }
});