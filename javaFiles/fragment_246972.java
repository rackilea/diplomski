Map<String, String> env = new HashMap<>(); 
env.put("create", "true");
Path path = Paths.get("test.zip");
URI uri = URI.create("jar:" + path.toUri());
try (FileSystem fs = FileSystems.newFileSystem(uri, env))
{
    Path nf = fs.getPath("new.txt");
    try (Writer writer = Files.newBufferedWriter(nf, StandardCharsets.UTF_8, StandardOpenOption.CREATE)) {
        writer.write("hello");
    }
}