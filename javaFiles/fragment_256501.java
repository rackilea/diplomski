public void closeQuietly(Closeable closeable) {
    if (closeable != null) {
        try {
            closeable.close();
        } catch (IOException ex) {
            // ignore
        }
    }
}