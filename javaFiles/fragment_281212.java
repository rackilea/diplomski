private void executeProgramFromClasspath() throws IOException {
    // Open resource stream.
    InputStream input = getClass().getResourceAsStream("/program.exe");
    if (input == null) {
        throw new IllegalStateException("Missing classpath resource.");
    }

    // Transfer.
    OutputStream output = null;
    try {
        // Create temporary file. May throw IOException.
        File temporaryFile = File.createTempFile(getClass().getName(), "");

        output = new FileOutputStream(temporaryFile);
        output = new BufferedOutputStream(output);
        IOUtils.copy(input, output);
    } finally {
        // Close streams.
        IOUtils.closeQuietly(input);
        IOUtils.closeQuietly(output);
    }

    // Execute.
    try {
        String path = temporaryFile.getAbsolutePath();
        ProcessBuilder processBuilder = new ProcessBuilder(path);
        Process process = processBuilder.start();
        process.waitFor();
    } catch (InterruptedException e) {
        // Optional catch. Keeps the method signature uncluttered.
        throw new IOException(e);
    } finally {
        // Clean up
        if (!temporaryFile.delete()) {
            // Log this issue, or throw an error.
        }
    }
}