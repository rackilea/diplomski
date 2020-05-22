public static void compress(Path directory, int depth, Path zipArchiveFile) throws IOException {
    var uri = URI.create("jar:" + zipArchiveFile.toUri());
    var env = Map.of("create", Boolean.toString(Files.notExists(zipArchiveFile, NOFOLLOW_LINKS)));

    try (var fs = FileSystems.newFileSystem(uri, env)) {
        Files.walkFileTree(directory, Set.of(), depth, new SimpleFileVisitor<>() {

            private final Path archiveRoot = fs.getRootDirectories().iterator().next();

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                // Don't include the directory itself
                if (!directory.equals(dir)) {
                    Files.createDirectory(resolveDestination(dir));
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.copy(file, resolveDestination(file), REPLACE_EXISTING);
                return FileVisitResult.CONTINUE;
            }

            private Path resolveDestination(Path path) {
                /*
                 * Use Path#resolve(String) instead of Path#resolve(Path). I couldn't find where the
                 * documentation mentions this, but at least three implementations will throw a 
                 * ProviderMismatchException if #resolve(Path) is invoked with a Path argument that 
                 * belongs to a different provider (i.e. if the implementation types don't match).
                 *
                 * Note: Those three implementations, at least in OpenJDK 12.0.1, are the JRT, ZIP/JAR,
                 * and Windows file system providers (I don't have access to Linux's or Mac's provider
                 * source currently).
                 */
                return archiveRoot.resolve(directory.relativize(path).toString());
            }

        });
    }
}