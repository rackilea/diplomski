public static <T> Observable<T> skipErrors(final Observable<Single<T>> singles) {
  Preconditions.checkNotNull(xs);
  return singles
    .flatMap(single -> single
        .toObservable()
        .onErrorResumeNext(Observable.empty())
    );
}