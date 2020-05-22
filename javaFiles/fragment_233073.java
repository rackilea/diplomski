Path folder = Paths.get("...");
try (DirectoryStream<Path> stream = Files.newDirectoryStream(folder, "*.txt")) {
    for (Path entry : stream) {
        // The entry can only be a text file
    }
} catch (IOException ex) {
    // An I/O problem has occurred
}