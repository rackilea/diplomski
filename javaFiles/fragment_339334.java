import java.io.IOException;
import java.io.OutputStream;

public class WrappedOutputStream extends OutputStream {

    private final OutputStream delegate;

    public WrappedOutputStream(final OutputStream delegate) {
        this.delegate = delegate;
    }

    public void close() throws IOException {
        // Do Nothing to allow Restlet to close the underlying stream
    }

    // TODO Delegate other Outpt Stream methods.
}