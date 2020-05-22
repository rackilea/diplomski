FileFilter filter = new FileFilter() {
    @Override
    public boolean accept(File pathname) {
        return pathname.getName().startsWith("Sample") && pathname.lastModified() > LASTMODIFIED_LIMIT;
    }
};