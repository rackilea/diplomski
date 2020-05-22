final List<Path> files = new ArrayList<>();
    Files.walkFileTree(Paths.get(myInputPath), new SimpleFileVisitor<Path>() {

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            files.add(file);
            return FileVisitResult.CONTINUE;
        }
    });