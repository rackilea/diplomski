ExecutorService executor = Executors.newFixedThreadPool(threadCount);
PdfOcrService service = ...
Path rootPath = Paths.get("/path/to/your/directory");
Files.walkFileTree(rootPath, new SimpleFileVisitor<Path>() {
    public void visitFile(Path path, BasicFileAttributes attrs) {
        executor.submit(() -> {
            service.performOcrOnFile(path);
        });
    }
});