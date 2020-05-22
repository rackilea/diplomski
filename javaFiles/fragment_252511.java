class RecursiveStream {
    static Stream<Path> listFiles(Path path) {
        if (Files.isDirectory(path)) {
            try { return Files.list(path).flatMap(RecursiveStream::listFiles); }
            catch (Exception e) { return Stream.empty(); }
        } else {
            return Stream.of(path);
        }
    }

    public static void main(String[] args) {
        listFiles(Paths.get(".")).forEach(System.out::println);
    }
}