final Path destination = Paths.get("pathToYourFile");
try (
    final InputStream in = createInputStreamHere();
) {
    Files.copy(in, destination);
}