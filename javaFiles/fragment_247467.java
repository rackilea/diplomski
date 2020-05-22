/**
 * This piped stream class allows to signal Exception between threads, allowing an exception produced in the writing
 * thread to reach the reading thread.
 *
 * @author Gerard on 10/11/2017.
 */
public class ExceptionAwarePipedOutputStream extends PipedOutputStream {

    private final ExceptionAwarePipedInputStream sink;

    public ExceptionAwarePipedOutputStream(ExceptionAwarePipedInputStream sink) throws IOException {
        super(sink);
        this.sink = sink;
    }

    /**
     * Signals connected {@link ExceptionAwarePipedInputStream} that an exception ocurred allowing to propagate it
     * across respective threads. This works as inter thread communication mechanism. So it allows to the reading thread
     * notice that an exception was thrown in the writing thread.
     *
     * @param exception The exception to propagate.
     */
    public void signalException(Throwable exception) {
        sink.signalException(exception);
    }
}