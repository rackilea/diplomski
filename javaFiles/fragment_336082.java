Map<String, ?> env = new HashMap<>();
URL url = getClass().getResource("/META-INF/MANIFEST.MF");
LOG.debug("MANIFEST=" + url.toURI());

// Correct the URL to either file system or war
{
    String s = url.toString().replaceFirst("META-INF/MANIFEST.MF", ""); // In case of war
    url = new URL(s); // Use jar:file: ...
    LOG.debug("ARCHIVE=" + url.toURI());
}

FileSystem fs = FileSystems.newFileSystem(url.toURI(), env);
LOG.debug("FILESYSTEM=" + fs.isOpen());

Path path = fs.getPath("/WEB-INF/classes/testcases");
LOG.debug("PATH=" + path.getFileName());

Set<FileVisitOption> options = new HashSet<FileVisitOption>();

int maxDepth = 1;

FileVisitor<Path> visitor = new FileVisitor<Path>() {

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        LOG.debug(file.getFileName());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

};

Files.walkFileTree(path, options, maxDepth, visitor);