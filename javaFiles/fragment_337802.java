class ResultReceiver {

    Map<String, CompletableFuture<Object>> subscribers;

    CompletableFuture<Object> register(String responseId) {
        CompletableFuture<Object> future = new CompletableFuture<Object>();
        this.subscribers.put(responseId, future);

        return future;
    }

    public void externalResponse(String responseId, Object result) {
        this.subscribers.get(responseId).complete(result);
    }
}