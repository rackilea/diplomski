public String[] ReadScanlist(String fileIn) throws IOException {
    final Path root = Paths.get("C:/data");
    try (final Stream<String> lines = Files.lines(root.resolve(fileIn), StandardCharsets.UTF_8)) {
        return lines.toArray(String[]::new);
    }
}