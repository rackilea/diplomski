File[] files = dir.listFiles(new FilenameFilter() {   
    @Override
    public boolean accept(File file, String name) {
        return !file.isDirectory();
    }
});