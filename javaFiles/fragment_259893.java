class WindowsFileSystem
    extends FileSystem
{
..............................
..............................
@Override
    public WatchService newWatchService()
        throws IOException
    {
        return new WindowsWatchService(this);
    }
}