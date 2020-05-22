class PathVisitor extends SimpleFileVisitor<Path> {
    private int fileCount = 0;

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
            throws IOException {
        fileCount++;
        return FileVisitResult.CONTINUE;
    }

    public int getFileCount() {
        return fileCount;
    }
}