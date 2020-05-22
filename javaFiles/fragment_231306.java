public void flush() throws IOException {
    synchronized (lock) {
        flushBuffer();   // Flushes this BufferedWriters buffers to 'out'.
        out.flush();     // Now flushes 'out' (the stream it wraps).
    }
}