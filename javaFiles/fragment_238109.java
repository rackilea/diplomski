public static List<String> readFile(String file)
        throws IOException {
    Path p = Paths.get(file);
    if (!Files.exists(p)) {
        throw new IOException( "No such file: " + file);
    } else if (!Files.isRegularFile(p)) {
        throw new IOException( "No regular file: " + file);
    } else if (!Files.isReadable(p)) {
        throw new IOException( "Access denied: " + file);
    } else if (Files.size(p) == 0) {
        throw new IOException( "Empty file: " + file);
    }
    return Files.readAllLines(p);
}