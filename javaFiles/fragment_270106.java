<E extends Throwable> E getCauseOfClass(RuntimeException e, Class<E> exceptionClass) {
    Throwable t = e;
    do {
        if (exceptionClass.isAssignableFrom(t.getClass())) {
            return (E) t;
        }
    } while ((t = t.getCause()) != null);  // go deeper in cause chain
    throw e;                               // if not found, re-throw
}