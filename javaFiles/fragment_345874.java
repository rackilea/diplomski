@Value.Immutable
public abstract class MyRuntimeException extends RuntimeException {
    public abstract long timestamp();
    public abstract long secretTimestamp();
    @Override public abstract String toString(); //<-- forces toString impl
}