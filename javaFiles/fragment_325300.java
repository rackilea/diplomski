FileUtils.copyDirectory(new File(srcDir), new File(destDir), new FileFilter() {
    @Override
    public boolean accept(File pathname) {
        return pathname.canRead();
    }
});