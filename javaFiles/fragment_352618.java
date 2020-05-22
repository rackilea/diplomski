public static BufferedImage  read(File input) throws IOException {
    if (input == null) {
        throw new IllegalArgumentException("input == null!");
    }
    if (!input.canRead()) {
        throw new IIOException("Can't read input file!");
    }
    ....
}