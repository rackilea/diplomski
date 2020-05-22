Path path = Paths.get("C:/foo.jar");
URI uri = new URI("jar", path.toUri().toString(),  null);

Map<String, String> env = new HashMap<>();
env.put("create", "true");

FileSystem fileSystem = FileSystems.newFileSystem(uri, env);
Path file = fileSystem.getPath("bar.html");
System.out.println(file);