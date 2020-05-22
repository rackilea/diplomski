futureTask = new FutureTask<Object>(new Callable() {
    public Object call() throws ResponseException {
        SendAggregateEvent(request);
        return null;
    }
};