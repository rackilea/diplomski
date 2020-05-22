/**
     * Close the underlying message entity input stream (if available and open)
     * as well as releases any other resources associated with the response
     * (e.g. {@link #bufferEntity() buffered message entity data}).
     * <p>
     * This operation is idempotent, i.e. it can be invoked multiple times with the
     * same effect which also means that calling the {@code close()} method on an
     * already closed message instance is legal and has no further effect.
     * </p>
     * <p>
     * The {@code close()} method should be invoked on all instances that
     * contain an un-consumed entity input stream to ensure the resources associated
     * with the instance are properly cleaned-up and prevent potential memory leaks.
     * This is typical for client-side scenarios where application layer code
     * processes only the response headers and ignores the response entity.
     * </p>
     * <p>
     * Any attempts to manipulate (read, get, buffer) a message entity on a closed response
     * will result in an {@link IllegalStateException} being thrown.
     * </p>
     *
     * @throws ProcessingException if there is an error closing the response.
     * @since 2.0
     */