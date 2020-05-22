public void afterDate() throws IOException {
    final String pathToDirectory = "/path/to/directory";
    final long afterDate = new Date().getTime();
    final List<Path> paths = new ArrayList<>();
    final Path directory = Paths.get(pathToDirectory);
    try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directory)) {
        for (Path path : directoryStream) {
            final BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
            final long creationTime = attr.creationTime().toMillis();
            if (creationTime >= afterDate) {
                paths.add(path);
            }
        }
    }
    for (final Path path : paths) {
        System.out.println(path.getFileName());
    }

}