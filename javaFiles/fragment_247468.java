/**
 * This piped stream class allows to signal Exception between threads, allowing an exception produced in the writing
 * thread to reach the reading thread.
 *
 * @author Gerard on 10/11/2017.
 */
public class ExceptionAwarePipedInputStream extends PipedInputStream {

    private volatile Throwable exception;

    void signalException(Throwable exception) {
        this.exception = exception;
    }

    @Override
    public int read(byte[] b) throws IOException {
        final int read = super.read(b);
        checkException();
        return read;
    }

    @Override
    public synchronized int read() throws IOException {
        final int read = super.read();
        checkException();
        return read;
    }

    @Override
    public synchronized int read(byte[] b, int off, int len) throws IOException {
        final int read = super.read(b, off, len);
        checkException();
        return read;
    }

    private void checkException() throws IOException {
        if (exception != null) {
            throw new IOException(exception.getMessage(), exception);
        }
    }
}