Filter filter = new Filter() {
    @Override
    public boolean interested(int level, String path, File file) {
        return path.endsWith(".java");
    }
};

FileHandler fileHandler = new FileHandler() {
    @Override
    public void handle(int level, String path, File file) {
        // Your long implementation for FileHandler
    }
};
new DirExplorer(filter, fileHandler).explore(projectDir);