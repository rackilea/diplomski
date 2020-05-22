/**
 * Reads a single character.
 *
 * @return     The character read, or -1 if the end of the stream has been
 *             reached
 *
 * @exception  IOException  If an I/O error occurs
 */
public int read() throws IOException {
    synchronized (lock) {
        ensureOpen();
        if (next >= length)
            return -1;
        return str.charAt(next++);
    }
}

/** Check to make sure that the stream has not been closed */
private void ensureOpen() throws IOException {
    if (str == null)
        throw new IOException("Stream closed");
}

/**
 * Closes the stream and releases any system resources associated with
 * it. Once the stream has been closed, further read(),
 * ready(), mark(), or reset() invocations will throw an IOException.
 * Closing a previously closed stream has no effect.
 */
public void close() {
    str = null;
}