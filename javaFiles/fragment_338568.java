package mcve.util;

import java.io.*;

public class PrintStreamEx extends PrintStream {
    public PrintStreamEx(OutputStream out) {
        super(new HelperOutputStream(out));
    }

    /**
     * @return the last IOException thrown by the output,
     *         or null if there isn't one
     */
    public IOException getLastException() {
        return ((HelperOutputStream) out).lastException;
    }

    @Override
    protected void clearError() {
        super.clearError();
        ((HelperOutputStream) out).setLastException(null);
    }

    private static class HelperOutputStream extends FilterOutputStream {
        private IOException lastException;

        private HelperOutputStream(OutputStream out) {
            super(out);
        }

        private IOException setLastException(IOException e) {
            return (lastException = e);
        }

        @Override
        public void write(int b) throws IOException {
            try {
                super.write(b);
            } catch (IOException e) {
                throw setLastException(e);
            }
        }

        @Override
        public void write(byte[] b) throws IOException {
            try {
                super.write(b);
            } catch (IOException e) {
                throw setLastException(e);
            }
        }

        @Override
        public void write(byte[] b, int off, int len) throws IOException {
            try {
                super.write(b, off, len);
            } catch (IOException e) {
                throw setLastException(e);
            }
        }

        @Override
        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e) {
                throw setLastException(e);
            }
        }

        @Override
        public void close() throws IOException {
            try {
                super.close();
            } catch (IOException e) {
                throw setLastException(e);
            }
        }
    }
}