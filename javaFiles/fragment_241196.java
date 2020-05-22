public static PathReference getPath(final URI resPath) throws IOException
{
    try
    {
        // first try getting a path via existing file systems
        return new PathReference(Paths.get(resPath), null);
    }
    catch (final FileSystemNotFoundException e)
    {
        /*
         * not directly on file system, so then it's somewhere else (e.g.:
         * JAR)
         */
        final Map<String, ?> env = Collections.emptyMap();
        final FileSystem fs = FileSystems.newFileSystem(resPath, env);
        return new PathReference(fs.provider().getPath(resPath), fs);
    }
}