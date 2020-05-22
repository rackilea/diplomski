public static <T> ResponseOrError<T> fromError(Throwable throwable) {
    return new ResponseOrError<>(throwable);
}

public static <T> ResponseOrError<T> fromData(T data) {
    return new ResponseOrError<>(data);
}