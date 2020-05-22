FileFilter fileFilter = new FileFilter() {
    @Override
    public boolean accept(File pathname)
    {
        return !pathname.getPath().endsWith("file.tmp") && !pathname.getPath().endsWith("file.temp");
    }
};