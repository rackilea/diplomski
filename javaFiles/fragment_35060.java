public static void close(Closeable closeable) {
    if (closeable != null) {
        try {
            closeable.close();
        }
        catch (IOException e) {
            //logging
        }
    }
}