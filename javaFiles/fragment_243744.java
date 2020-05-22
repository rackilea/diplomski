final Path dstfile = Paths.get("h:", "abc.zip");

// ...

try (
    final InputStream in = url.openStream();
) {
    Files.copy(in, dstfile, StandardOpenOption.CREATE_NEW);
}