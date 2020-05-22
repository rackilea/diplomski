class Status implements Serializable {
  // for serialization
  private enum InternalStatus {
    OK, TIMEOUT, EXCEPTION
  }
  public static final Status OK = new Status(null, InternalStatus.OK);
  public static final Status TIMEOUT = new Status(null, InternalStatus.TIMEOUT);

  private final Exception exception;
  private final InternalStatus internalStatus;

  private Status(Exception exception, InternalStatus internalStatus) {
    this.exception = exception;
    this.internalStatus = internalStatus;
  }

  public Exception getException() {
    return exception;
  }

  public static Status exceptionStatus(Exception cause) {
    if (cause == null) throw new NullPointerException();
    return new Status(cause, InternalStatus.EXCEPTION);
  }

  // deserialization logic handling OK and TIMEOUT being singletons
  private final Object readResolve() {
    switch (internalStatus) {
    case InternalStatus.OK:
      return OK;
    case InternalStatus.TIMEOUT:
      return TIMEOUT;
    default:
      return this;
    }
  }      
}