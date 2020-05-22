Files.walkFileTree(sourceFile, new SimpleFileVisitor<Path>()
{
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
    {
        Files.copy(file, targetFile.resolve(sourceFile.relativize(file)), 
            StandardCopyOption.COPY_ATTRIBUTES);
        return super.visitFile(file, attrs);
    }
});