public void handleException(RunnableWrapper r) {
    try {
        r.run();
    }
    catch(Exception e) {
        throw new CompletionException(e);
    }
}