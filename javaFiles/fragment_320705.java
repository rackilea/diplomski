File[] files = rootDir.listFiles(new FileFilter() {
    private final FileNameExtensionFilter filter =
        new FileNameExtensionFilter("Compressed files",
            "zip", "jar", "z", "gz", "tar", "bz2", "bz");
    public boolean accept(File file) {
        return filter.accept(file);
    }
});