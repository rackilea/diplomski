public class DetailedDuplicateKeyException extends DuplicateKeyException {
    public DetailedDuplicateKeyException(String msg) {
        // Instead of just calling super parse the message here.
        super(msg);
    }
}