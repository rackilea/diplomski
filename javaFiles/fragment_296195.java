public class ChainedWorkerBuilder {

    private List<SwingWorker> workers;
    private SwingWorker current;

    public ChainedWorkerBuilder() {
        workers = new ArrayList<>(25);
    }

    public ChainedWorkerBuilder add(SwingWorker worker) {
        workers.add(worker);
        return this;
    }

    public void execute() {
        if (!workers.isEmpty()) {
            SwingWorker worker = workers.remove(0);
            worker.addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    if ("state".equals(evt.getPropertyName())) {
                        SwingWorker source = (SwingWorker)evt.getSource();
                        switch (source.getState()) {
                            case DONE:
                                source.removePropertyChangeListener(this);
                                execute();
                                break;
                        }
                    }
                }
            });
        }
    }

}