public void myMethod() {
    CompletableFuture<?>[] futures = { getQuestion(), getAnswer() };

    // make sure all the futures are executed.
    CompletableFuture.allOf(futures).join();
}