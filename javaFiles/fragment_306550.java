public abstract class Process implements Runnable {
    private final Properties props;
    private final String processName;

    public Process(String processName, Properties props) {
        this.processName = processName;
        this.props = props;
    }

    protected abstract void shutdown();
    protected abstract void run(String processName, Properties props);

    @Override
    public final void run() {
        run(processName, props);
    }

}

public class ProcessA extends Process {
    private ProcessConsumer<byte[], byte[]> consumer;

    public ProcessA(String processName, Properties props) {
        super(processName, props);
    }

    @Override
    public void shutdown() {
        consumer.wakeup();
    }

    @Override
    protected void run(String processName, Properties props) {
        consumer = new ProcessConsumer<>(props);
    }
}