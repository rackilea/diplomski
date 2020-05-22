class NativeTask {
    public NativeTask() {}

    public void doTask()
            throws InterruptedException {
        NativeTaskSelector selector = new NativeTaskSelector(this);
        try {
            selector.registerStart();
            doTask0(); // native method
            if (Thread.interrupted())
                    throw new InterruptedException();
        } finally {
            selector.registerEnd();
            try { selector.close(); } catch (IOException impossible) {}
        }
    }
    /* The long-running native operation. */
    native private void doTask0();

    public void wakeupTask() { wakeupTask0(); }
    /* A way to cause the native operation to wake up. */
    native private void wakeupTask0();
}

class NativeTaskSelector extends AbstractSelector {

    protected NativeTaskSelector(NativeTask task_) {
        super(null);
        task = task_;
    }

    public void registerStart() { begin(); }
    public void registerEnd() { end(); }

    final private NativeTask task;

    @Override
    public Selector wakeup() {
        task.wakeupTask();
        return this;
    }

    @Override
    protected void implCloseSelector() throws IOException {
    }

    @Override
    protected SelectionKey register(AbstractSelectableChannel arg0, int arg1,
            Object arg2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<SelectionKey> keys() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int select() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int select(long arg0) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int selectNow() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<SelectionKey> selectedKeys() {
        throw new UnsupportedOperationException();
    }

}