final Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);
final AsyncSubject<Integer> subject = AsyncSubject.create();
observable.subscribe(subject);
subject.subscribe(new Action1<Integer>() {
    @Override
    public void call(Integer integer) {
        // TODO
    }
});