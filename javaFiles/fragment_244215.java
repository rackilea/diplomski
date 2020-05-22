class HandelerFuture extends CompletableFuture<JsonArray> 
         implements Handler<AsyncResult<HttpResponse<Buffer>>> {
    @Override
    public void handle(AsyncResult<HttpResponse<Buffer>> ar) {
        if (ar.succeeded()) {
            JsonArray array = ar.result().bodyAsJsonArray();
            super.complete(array);
        } else {
            super.completeExceptionally(ar.cause());
        }
    }
}