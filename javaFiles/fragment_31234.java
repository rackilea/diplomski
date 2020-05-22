public static Promise<Result> doSomethingAsync() {
  if (...) {
    return getData();
  } else {
    return F.Promise.pure(ok(...));
  }
}