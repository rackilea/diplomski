public static BufferedImage read(File input) throws IOException {
    ...
    if (!input.canRead()) {
        throw new IIOException("Can't read input file!");   // <- line 1301
    }
    ...
}