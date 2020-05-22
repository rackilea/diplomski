BehaviorSubject<Integer> bs = BehaviorSubject.create(1);

bs.observeOn(Schedulers.trampoline())
.map(t -> measure())
.concatMap(fa -> 
    Observable.range(0, fa.length).map(i -> fa[i])
    .finallyDo(() -> bs.onNext(1))
)