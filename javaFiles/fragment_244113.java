public class SuppressedException extends IOException {

    public SuppressedException(Throwable cause) {
        super(cause);
    }
}