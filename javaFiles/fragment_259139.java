public Map<String, Object> getRequestContext() {
    if (isThreadLocalRequestContext()) {
        if (!requestContext.containsKey(Thread.currentThread())) {
            requestContext.put(Thread.currentThread(), new EchoContext(currentRequestContext));
        }
        return requestContext.get(Thread.currentThread());
    }
    return currentRequestContext;
}