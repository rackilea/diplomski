public abstract class ChainedWorker<T, V> extends SwingWorker<T, V> {

    private ChainedWorker<T, ?> next;
    private T previousValue;

    public ChainedWorker(ChainedWorker<T, ?> next) {
        this.next = next;
    }

    public void setPreviousValue(T previousValue) {
        this.previousValue = previousValue;
    }

    @Override
    protected void done() {
        try {
            T previous = get();
            if (next != null) {
                next.setPreviousValue(previous);
                next.execute();
            }
        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }
    }

}