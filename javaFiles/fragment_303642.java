public static OutputStream asyncOutputStream(final OutputStream out) throws IOException {
    PipedOutputStream pos = new PipedOutputStream();
    final PipedInputStream pis = new PipedInputStream(pos);
    new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                byte[] bytes = new byte[8192];
                for(int len; (len = pis.read(bytes)) > 0;)
                    out.write(bytes, 0, len);
            } catch(IOException ioe) {
                ioe.printStackTrace();
            } finally {
                close(pis);
                close(out);
            }
        }
    }, "async-output-stream").start();
    return pos;
}

static void close(Closeable closeable) {
    if (closeable != null) try {
        closeable.close();
    } catch (IOException ignored) {
    }
}