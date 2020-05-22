public class DatedFileHandler extends Handler {

    @Override
    public synchronized void publish(LogRecord r) {
        if (isLoggable(r)) {
            try {
                FileHandler h = new FileHandler(fileName(r), 0, 1, true);
                try {
                    h.setLevel(getLevel());
                    h.setEncoding(getEncoding());
                    h.setFilter(getFilter());
                    h.setFormatter(getFormatter());
                    h.setErrorManager(getErrorManager());
                    h.publish(r);
                } finally {
                    h.close();
                }
            } catch (IOException | SecurityException jm) {
                this.reportError(null, jm, ErrorManager.WRITE_FAILURE);
            }
        }
    }

    @Override
    public void flush() {
    }

    @Override
    public void close() {
        super.setLevel(Level.OFF);
    }

    private String fileName(LogRecord r) {
        return new SimpleDateFormat("'%h'yyyyMMdd_HHmmss").format(new Date(r.getMillis()));
    }
}