private static FileSystem createZipFileSystem(String zipFileName, boolean create) throws IOException {
    final Path path = Paths.get(zipFileName);
    final URI uri = URI.create("jar:" + path.toUri());
    final Map<String,String> env = new HashMap<String,String>();

    if(create) {
        env.put("create", "true");
    }

    return FileSystems.newFileSystem(uri, env);
}