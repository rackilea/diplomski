private static final byte[] secretSignature = { 10, 20 };

void writeData(Path file)
throws IOException {
    try (OutputStream out = new BufferedOutputStream(
            Files.newOutputStream(file))) {
        out.write(secretSignature);

        ZipOutputStream zip = new ZipOutputStream(out);
        // Write zip entries
        zip.finish();
    }
}

void readData(Path file)
throws IOException {
    try (InputStream in = new BufferedInputStream(
            Files.newInputStream(file))) {
        in.skip(secretSignature.length);

        ZipInputStream zip = new ZipInputStream(in);
        ZipEntry entry;
        while ((entry = zip.getNextEntry()) != null) {
            // Read entry
        }
    }
}