public class ConnectionFailedException extends RuntimeException {

    private static final long serialVersionUID = -7168847000818691293L;

    public ConnectionFailedException(Throwable cause) {
        super(cause);
    }

    public ConnectionFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}