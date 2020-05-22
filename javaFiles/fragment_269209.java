public static void printFiles(Path start) {
    try {
        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
            Path parent;
            @Override
            public FileVisitResult visitFile(Path file,
                            BasicFileAttributes attrs) throws IOException {
                if (parent == null)
                    parent = file.getParent();
                System.out.println(parent.relativize(file));
                return FileVisitResult.CONTINUE;
            }
        });
    } catch (IOException e) {
        e.printStackTrace();
    }
}