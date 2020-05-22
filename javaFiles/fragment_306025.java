.flatMapCompletable(new Function<Data, CompletableSource>() {
    @Override
    public CompletableSource apply(Data data) throws Exception {
        return repository.insert(data);
    }
})