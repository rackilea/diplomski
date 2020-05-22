/**
 * Get the thrown target exception.
 *
 * <p>This method predates the general-purpose exception chaining facility.
 * The {@link Throwable#getCause()} method is now the preferred means of
 * obtaining this information.
 *
 * @return the thrown target exception (cause of this exception).
 */
public Throwable getTargetException() {
    return target;
}

/**
 * Returns the cause of this exception (the thrown target exception,
 * which may be {@code null}).
 *
 * @return  the cause of this exception.
 * @since   1.4
 */
public Throwable getCause() {
    return target;
}