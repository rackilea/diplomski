/** Called by the process reaper thread when the process exits. */
synchronized void processExited() {
    synchronized (closeLock) {
        try {
            InputStream in = this.in;
            // this stream is closed if and only if: in == null
            if (in != null) {
                byte[] stragglers = drainInputStream(in);
                in.close();
                this.in = (stragglers == null) ?
                    ProcessBuilder.NullInputStream.INSTANCE :
                    new ByteArrayInputStream(stragglers);
            }
        } catch (IOException ignored) {}
    }
}