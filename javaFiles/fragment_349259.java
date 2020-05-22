@Override
protected void doRun() {
    beforeExecution();

    runnable.run();

    afterExecution();
}