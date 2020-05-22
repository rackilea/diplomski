final Path zip = file.toPath();

final Map<String, ?> env = Collections.emptyMap();
final URI uri = URI.create("jar:" + zip.toUri());

try (
    final FileSystem zipfs = FileSystems.newFileSystem(uri, env);
)  {
    Files.write(zipfs.getPath("into/zip"), buf,
        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
}