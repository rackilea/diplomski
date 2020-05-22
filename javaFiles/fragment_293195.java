public Observable<List<T>> searchModelsInView(View view, final Collection<String> searchTerms,
            KeyMatchLevel keyMatchLevel, int queryLim) {

return Observable.defer(new Func0<Observable<List<T>>>(){

        @Override
        public Observable<List<T>> call() {
            return Observable.just(
                    searchModelsTask(view, new HashSet<>(searchTerms), keyMatchLevel, queryLim));
        }
    });
}