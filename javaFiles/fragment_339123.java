final PathMatcher matcher = FileSystems.getDefault().getPathMatcher("regex:.*Correct_\\d{4}-\\d{2}-\\d{2}_\\d{2}-\\d{2}\\.txt");
Files.walkFileTree(Paths.get(workDir.toString()), new SimpleFileVisitor<Path>() 
{
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException
    {
        if (dir.getFileName().toString().equals("Reprocess"))
        {
             return SKIP_SUBTREE;
        }
        return CONTINUE;
    }//end public preVisitDirectory
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException 
    {
        if (matcher.matches(file))
        {
            files.add(file.toString());
        }//end if(matcher)
    return FileVisitResult.CONTINUE;
    }//end visitFile
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException 
    {
    return FileVisitResult.CONTINUE;
    }//end visitFileFailed
});//end Files.walkFileTree1