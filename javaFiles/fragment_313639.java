public static URL createURLWithContent(String content) throws IOException {
    Path tempFile = Files.createTempFile("UrlContent", null);
    tempFile.toFile().deleteOnExit();
    Files.writeString(tempFile, content);
    return tempFile.toUri().toURL();
}