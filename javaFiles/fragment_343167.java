/**
 * Close this application context, releasing all resources and locks that the
 * implementation might hold. This includes destroying all cached singleton beans.
 * <p>Note: Does <i>not</i> invoke {@code close} on a parent context;
 * parent contexts have their own, independent lifecycle.
 * <p>This method can be called multiple times without side effects: Subsequent
 * {@code close} calls on an already closed context will be ignored.
 */
@Override
void close();