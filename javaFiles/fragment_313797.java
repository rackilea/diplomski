private static Collection<Info> callService(int retryCount) {

    try {
        CompletableFuture<Collection<Info>> f =  invoke();
        return f.get(RETRY_DELAY, TimeUnit.MILLISECONDS);
    }catch(TimeoutException te) {
        if(retryCount > 0) {
            return callService(retryCount - 1);
        } else {
            throw new RuntimeException("Fatally failed!!");
        }
    } catch(Exception ee) {
        throw new RuntimeException("Unexpectedly failed", ee);
    }
}