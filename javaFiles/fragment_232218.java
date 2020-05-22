public abstract class Enclosing {

    protected interface JobHandler {
        void handle(Job job) throws JobException;
    }

    protected abstract JobHandler createJobHandler();

    // public methods omitted

    private void doTheJob(Job job) {
        createJobHandler().handle(job);
    }
}