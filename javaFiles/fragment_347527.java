fileDialog.setFilenameFilter(new FilenameFilter() {
    @Override
    public boolean accept(File dir, String name) {
        return dir.isFile();
    }
});