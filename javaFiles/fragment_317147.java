Path inputPath = Paths.get("archive.tar.gz");
Path outputPath = Paths.get("archive.tar");

try (InputStream fin = Files.newInputStream(inputPath );
        OutputStream out = Files.newOutputStream(outputPath);) {
    GZipCompressorInputStream in = new GZipCompressorInputStream(
        new BufferedInputStream(fin));

    // Read and write byte by byte
    final byte[] buffer = new byte[buffersize];
    int n = 0;
    while (-1 != (n = in.read(buffer))) {
        out.write(buffer, 0, n);
    }
}