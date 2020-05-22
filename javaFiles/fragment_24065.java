Task<Boolean> listLoader = new Task<Boolean>() {
    {
        setOnSucceeded(workerStateEvent -> {
            System.out.println("Done");
        });

        setOnFailed(workerStateEvent -> getException().printStackTrace());
    }

    @Override
    protected Boolean call() throws Exception {
        try {
            Files.walkFileTree(Paths.get(currentDirectoryController().getDir().getAbsolutePath()), new HashSet<FileVisitOption>(Arrays.asList(FileVisitOption.FOLLOW_LINKS)),
                    Integer.MAX_VALUE, new SimpleFileVisitor<Path>() {
                        @Override
                        public FileVisitResult visitFile(Path file , BasicFileAttributes attrs) throws IOException {
                            return FileVisitResult.CONTINUE;
                        }

                        @Override
                        public FileVisitResult visitFileFailed(Path file , IOException e) throws IOException {
                            return FileVisitResult.SKIP_SUBTREE;
                        }

                        @Override
                        public FileVisitResult preVisitDirectory(Path dir , BasicFileAttributes attrs) throws IOException {
                            FilePane filePane = new FilePane(new KFile(dir.toFile()), cont);
                            Platform.runLater(() -> fileContainer.getChildren().add(filePane)); // TODO bulk updates to prevent posting runables too frequently
                            return FileVisitResult.CONTINUE;
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }
};

Thread loader = new Thread(listLoader);
loader.setDaemon(true);
loader.start();