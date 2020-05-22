apiService.getListObservable()
.subscribeOn(Schedulers.io)
.flatMapIterable(new Function<List<MyClassA>, List<MyClassA>>() {
    @Override public List<MyClassA> apply(List<MyClassA> v) {
        return v;
    }
})
.filter(new Predicate<MyClassA>() {
    @Override public boolean test(MyClassA v) {
        return v.value2 == 10;
    }
})
.toList()
.observeOn(AndroidSchedulers.mainThread())
.subscribe(...);