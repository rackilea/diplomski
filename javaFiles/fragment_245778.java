public static void main(final String... args)
    throws IOException
{
    final Map<String, ?> env = Collections.emptyMap();
    final String jarName = "/opt/sunjdk/1.6/current/jre/lib/plugin.jar";
    final URI uri = URI.create("jar:file:" + jarName);
    final FileSystem fs = FileSystems.newFileSystem(uri, env);
    final Path dir = fs.getPath("/");
    for (Path entry : Files.newDirectoryStream(dir))
        System.out.println(entry);
}