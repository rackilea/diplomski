Path folder = Paths.get("...");
try (DirectoryStream<Path> stream = Files.newDirectoryStream(folder)) {
    for (Path entry : stream) {
        // Process the entry
    }
} catch (IOException ex) {
    // An I/O problem has occurred
}