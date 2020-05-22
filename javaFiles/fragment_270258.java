public MyFutureTask<V> extends FutureTask<V> {

    private Runnable myTask;

    public MyFutureTask(Runnable runnable, V result) {
        super(runnable, result);
        this.myTask = runnable;
    }

    public Runnable getMyTask() {
        return myTask;
    }        
}