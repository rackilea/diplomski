@Override
protected void doRun() throws InterruptedException {
    beforeExecution();

    while(!isInterrupted()) {
        runnable.run();
        Thread.sleep(millis);
    }

    afterExecution();
}