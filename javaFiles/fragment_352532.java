/**
 * Zip a collection of files and pipe the output to an InputStream 
 */
public static InputStream zipSource(Collection<Path> paths) throws IOException {
    // Pipe pair. We zip to the output stream in a separate thread. The data is
    // then available to be read from the input stream.
    PipedOutputStream out = new PipedOutputStream();
    PipedInputStream in = new PipedInputStream(out);

    // Zip the file to the input stream in another thread
    zipExecutor.execute(() -> {
        try {
            zip(paths, out);
        } catch (IOException e) {
            System.err.println("Zip failed " + e);
        }
    });

    return in;
}

/**
 * Zip a collection of files to an output stream
 */
public static void zip(Collection<Path> paths, OutputStream out) throws IOException {
    try (ZipOutputStream zout = new ZipOutputStream(out)) {
        for (Path path : paths) {
            zout.putNextEntry(new ZipEntry(path.getFileName().toString()));
            Files.copy(path, zout);
            zout.closeEntry();
        }
    }
}

private static final Executor zipExecutor = Executors.newCachedThreadPool(r -> {
    Thread t = new Thread(r, "zip task");
    t.setDaemon(true);
    return t;
});