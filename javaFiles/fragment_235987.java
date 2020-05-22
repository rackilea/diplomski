private PublishSubject<Boolean> subject = PublishSubject.create();
    public Observable<Boolean> observable = subject.asObservable();


    public void setConnection(boolean connection) {
        this.connection = connection;
        subject.onNext(this.connection);
    }