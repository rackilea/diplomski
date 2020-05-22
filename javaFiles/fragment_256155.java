private static void listDirectoryAndFiles() throws IOException {
    final Path root = Paths.get("C:/Test");
    Files.walkFileTree(root, EnumSet.noneOf(FileVisitOption.class),
            Integer.MAX_VALUE, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir,
                        BasicFileAttributes attrs) throws IOException {
                    System.out.println(dir.toString());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file,
                        BasicFileAttributes attrs) throws IOException {
                    System.out.println(file.toString());
                    return FileVisitResult.CONTINUE;
                }
            });
}