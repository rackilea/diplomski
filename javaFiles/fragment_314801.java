Observable<User> userObservable = new RestClient().getUserById(1234);
userObservable.flatMap(new Func1<User, Observable<User>>() {
    @Override
    public Observable<User> call(final User user) {
        OtherRestClient otherRestClient = new OtherRestClient();

        // Second network call. It retrieves an Observable<UserAdditionalInfo>
        Observable<UserAdditionalInfo> additionalObservable = otherRestClient.getUserAdditionalInfo(user.getUserCode());

        return additionalObservable.map(new Func1<UserAdditionalInfo, User>() {
            @Override
            public User call(final UserAdditionalInfo uai) {
                user.setXXX(uai.getXXX());
                // ... any additional calls
                return user;
            }            
        });
    }
}).subscribe(o -> System.out.println(o));