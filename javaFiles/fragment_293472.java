class Progress {
    private int task;
    private int element;

    public Progress(int task, int element) {
        super();
        this.task = task;
        this.element = element;
    }
        ...
}

public class Model extends SwingWorker<Integer, Progress> {
    ...
    @Override
    protected Integer doInBackground() throws Exception {
            ...
            publish(new Progress(i, ii));
        }
}