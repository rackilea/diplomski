final Path dir = Paths.get("/Users/NiranjanSubramanian/Desktop/TestFiles");
try (final OutputStream out = Files.newOutputStream(Paths.get("input.csv"))) {
  for (final Path file : Files.newDirectoryStream(dir)) {
    Files.copy(file, out);
  }
}