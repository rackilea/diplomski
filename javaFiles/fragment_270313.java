finally {
    try {
        if (closeable != null) {
            closeable.close();
        }
    } catch (IOException ioe) {
        // ignore
    }
}