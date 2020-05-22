myFuture = executorVariable.submit(new Runnable() {
    @Override
    public void run() {
        runFuture();
    }
});