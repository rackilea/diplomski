static <T> T executeAndProcess(Supplier<T> s) {
    preExecute();
    T result = s.get();
    postExecute();
    return result;
}