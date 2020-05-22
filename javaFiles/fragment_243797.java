public static void closeQuietly(Object object) {
    try {
        if (object instanceof Closeable)
            ((Closeable)object).close();
        else if (object instanceof Socket)
            ((Socket)object).close();
        else if (object instanceof ServerSocket)
            ((ServerSocket)object).close();
        else 
            // use reflections to call close() if you must.

    } catch (IOException ignored) {
        // ignored
    }
}