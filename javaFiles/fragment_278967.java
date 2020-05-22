class LongRunningTask implements Callable<MyPojo> {
    private final String input;

    public LongRunningTask(String input) {
        this.input = input;
    }

    @Override
    public MyPojo call() {
        // Some long running task
        return myPojo;
    }
}