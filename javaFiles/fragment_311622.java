final Path root = Paths.get("/root");
final Path temp = Files.createTempDirectory(null);
Files.walkFileTree(root, new SimpleFileVisitor<Path>() {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (attrs.isRegularFile()) {
            Files.copy(file, temp.resolve(file.getFileName()));
            Files.delete(file);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        if (!dir.equals(root))
            Files.delete(dir);
        return FileVisitResult.CONTINUE;
    }           
});

Files.walkFileTree(temp, new SimpleFileVisitor<Path>() {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (attrs.isRegularFile()) {
            Files.copy(file, root.resolve(file.getFileName()));
            Files.delete(file);
        }
        return FileVisitResult.CONTINUE;
    }
});