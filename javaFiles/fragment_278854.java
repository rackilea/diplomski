final int BUFFER_SIZE = 1024 * 64;
Path textFile = Paths.get(".... .txt");
Path gzFile = textFile.resolveSibling(textFile.getFileName().toString() + ".gz");

try (OutputStream out = new GzipOutputStream(Files.newOutputStream(gzFile), BUFFER_SIZE))) {
    Files.copy(textFile, out);
}

try (InputStream in = new GzipInputStream(Files.newInputStream(gzFile), BUFFER_SIZE))) {
    Files.copy(in, textFile);
}