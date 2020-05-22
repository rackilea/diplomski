public static <T> Observable.Transformer<T, ResponseOrError<T>> toResponseOrErrorObservable() {
    return new Observable.Transformer<T, ResponseOrError<T>>() {

        @Override
        public Observable<ResponseOrError<T>> call(final Observable<T> observable) {
            return observable
                    .map(new Func1<T, ResponseOrError<T>>() {
                        @Override
                        public ResponseOrError<T> call(final T t) {
                            return ResponseOrError.fromData(t);
                        }
                    })
                    .onErrorResumeNext(new Func1<Throwable, Observable<? extends ResponseOrError<T>>>() {
                        @Override
                        public Observable<? extends ResponseOrError<T>> call(final Throwable throwable) {
                            return Observable.just(ResponseOrError.<T>fromError(throwable));
                        }
                    });
        }
    };
}