private static final Map<String, ?> ENV = Collections.emptyMap();

//

private static FileSystem getFileSystem(final String entryName)
    throws IOException
{
    final String uri = entryName.endsWith(".jar") || entryName.endsWith(".zip"))
        ? "jar:file:" + entryName : "file:" + entryName;
    return FileSystems.newFileSystem(URI.create(uri), ENV);
}