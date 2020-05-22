public static void main(String[] args) throws Exception {
    final Path path = Paths.get("path", "to", "folder");
    final Path txt = path.resolve("myFile.txt");
    final Path csv = path.resolve("myFile.csv");
    try (
            final Stream<String> lines = Files.lines(txt);
            final PrintWriter pw = new PrintWriter(Files.newBufferedWriter(csv, StandardOpenOption.CREATE_NEW))) {
        lines.map((line) -> line.split("\\|")).
                map((line) -> Stream.of(line).collect(Collectors.joining(","))).
                forEach(pw::println);
    }
}