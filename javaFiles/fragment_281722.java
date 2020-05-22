/**
 * Returns {@code true} if and only if the I/O thread will perform the
 * requested write operation immediately.  Any write requests made when
 * this method returns {@code false} are queued until the I/O thread is
 * ready to process the queued write requests.
 */
boolean isWritable();