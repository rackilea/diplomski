Path path = Paths.get("/Users/dnelepov/Downloads/test/");
    Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
        @Override
        public FileVisitResult visitFile(Path oneF, BasicFileAttributes attrs) throws IOException {
            System.out.println("FILE:" + oneF);
            if (Files.exists(oneF)) {
                System.out.println("EXISTS:" + oneF);
            }
            return FileVisitResult.CONTINUE;
        }
    });