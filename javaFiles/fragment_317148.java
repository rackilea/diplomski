Path inputPath = Paths.get("archive.tar");
Path outputPath = Paths.get("archive.tar.gz");

try (InputStream in = Files.newInputStream(inputPath);
        OutputStream fout = Files.newOutputStream(outputPath);) {
    GZipCompressorOutputStream out = new GZipCompressorOutputStream(
        new BufferedOutputStream(fout));

    // Read and write byte by byte
    final byte[] buffer = new byte[buffersize];
    int n = 0;
    while (-1 != (n = in.read(buffer))) {
        out.write(buffer, 0, n);
    }
}