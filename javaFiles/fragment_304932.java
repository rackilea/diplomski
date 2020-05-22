private static void store(String name, byte[] finishedClass) {
    Path path = Paths.get(name + ".class");
    try {
        Files.write(path, finishedClass);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}