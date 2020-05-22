class PublishAndMergeTransformer<A extends C, B extends C, C> implements ObservableTransformer<A, C> {

        final Function<A, Single<B>> f;

        public PublishAndMergeTransformer(Function<A, Single<B>> f) {
            this.f = f;
        }

        @Override
        public ObservableSource<C> apply(Observable<A> a) {
            return a.publish(aObservable ->
                    Observable.merge(
                            aObservable,
                            aObservable
                                    .flatMap(a1 -> f.apply(a1).toObservable())
                    )
            );
        }
    }