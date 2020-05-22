public class Throwable implements Serializable {
    private Throwable cause = this;        
    public synchronized Throwable initCause(Throwable cause) {
        if (this.cause != this)
            throw new IllegalStateException("Can't overwrite cause");
        if (cause == this)
            throw new IllegalArgumentException("Self-causation not permitted");
        this.cause = cause;
        return this;
    }
// ..
}