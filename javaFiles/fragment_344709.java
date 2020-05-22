Filter filter = (level, path, file) -> path.endsWith(".java");

FileHandler fileHandler = (level, path, file) -> {
    // Your implementation for FileHandler
};
new DirExplorer(filter, fileHandler).explore(projectDir);