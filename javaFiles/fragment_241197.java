public class PathReference implements AutoCloseable
{
   ...
    @Override
   public void close() throws Exception
    {
        if (this.fileSystem != null)
            this.fileSystem.close();
    }

    public Path getPath()
    {
        return this.path;
    }

    public FileSystem getFileSystem()
    {
        return this.fileSystem;
    }
}