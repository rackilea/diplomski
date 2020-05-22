public <E extends RuntimeException> E get(final Class<E> c,
    final Throwable t)
{
    try {
        return (E) getHandle(c).invokeExact(t);
    } catch (Error | RuntimeException e) {
        throw e;
    } catch (Throwable oops) {
        final RuntimeException exception = new IllegalStateException(oops);
        exception.addSuppressed(t);
        throw exception;
    }
}