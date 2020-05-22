public class ObservableSocketEvent extends EventObject {
    private final byte[] data;
    private final Exception exception;

    public ObservableSocketEvent(Object source) {
        super(source);
        this.data = null;
        this.exception = null;
    }

    public ObservableSocketEvent(Object source, byte[] data) {
        super(source);
        this.data = data;
        this.exception = null;
    }

    public ObservableSocketEvent(Object source, Exception exception) {
        super(source);
        this.data = null;
        this.exception = exception;
    }

    public byte[] getData() {
        return data;
    }

    public Exception getException() {
        return exception;
    }      
}