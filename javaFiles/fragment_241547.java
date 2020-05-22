public static void main(String[] args) throws IOException {
    Path target = Paths.get("C:/temp/test.txt"); // Returns a path, works ok.
    Path tempFile = Files.createTempFile("tempfile", null);
    Files.write(tempFile, "abc".getBytes(UTF_8), StandardOpenOption.WRITE);

    // Actual copy.
    Files.copy(tempFile, target, StandardCopyOption.REPLACE_EXISTING);

    // Cleanup.
    Files.delete(tempFile);
}