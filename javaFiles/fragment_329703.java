public Observable<LoginResult> getObservable() {
  if (hasCache()) {
      return Observable.just(lr);
  } else {
      return Observable.error(new RuntimeException("No cache"));
  }
}