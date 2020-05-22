Path folder = Paths.get("...");
try (DirectoryStream<Path> stream = Files.newDirectoryStream(folder,
        entry -> Files.isDirectory(entry))) {
    for (Path entry : stream) {
        // The entry can only be a directory
    }
} catch (IOException ex) {
    // An I/O problem has occurred
}