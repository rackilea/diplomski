static<T,U,R> Function<T,R> chain(
        Function<? super T, ? extends U> f1,
        Function<? super U, ? extends R> f2) {
    return t -> f2.apply(f1.apply(t));
}

stream.map(chain(Status::getUser, User::getId))