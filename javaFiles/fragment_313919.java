import java.util.concurrent.ExecutionException;
import javax.swing.SwingWorker;

public abstract class TracedSwingWorker<T, V> extends SwingWorker<T, V> {

    private final Exception cause;

    public TracedSwingWorker() {
        super();
        this.cause = new Exception("TracedSwingWorker created at:");
    }

    @Override
    protected final T doInBackground() throws Exception {
        try {
            return doWorkInBackground();
        }
        catch(Exception e) {
            if(this.cause != null) {
                Throwable cause = e;
                while(cause.getCause() != null) {
                    cause = cause.getCause();
                }

                cause.initCause(this.cause);
            }

            throw e;
        }
    }

    protected abstract T doWorkInBackground();

    // just for testing
    public static void main(String[] args) {
        new TracedSwingWorker<Void, Void>() {
            @Override
            protected Void doWorkInBackground() {
                throw new IllegalArgumentException("Exception in TracedSwingWorker!");
            }

            @Override
            protected void done() {
                try {
                    get();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }.execute();
    }
}