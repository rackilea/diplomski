public static EventualResponse synchCall(long timeout, TimeUnit timeUnit)
        throws InterruptedException, TimeoutException, EventualException
{
    CompletableFuture<EventualResponse> responseFuture = new CompletableFuture<>();
    Callback callback = new Callback() {
        public void onSuccess(EventualResponse response) { 
            responseFuture.complete(response); 
        }
        public void onFailure(Exception e) { 
            responseFuture.completeExceptionally(e); 
        }
    };
    try {
        /*ImmediateResponse immediateResponse = */asynchCall(callback); 
        // use immediateResponse if you need it
        return responseFuture.get(timeout, timeUnit);
    } catch (ImmediateException e) {
        throw new EventualException(e);
    } catch (ExecutionException ee) {
        throw new EventualException(ee.getCause());
    }
}