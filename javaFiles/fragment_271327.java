File[] file = dir.listFiles(new FileFilter() {
    @Override
    public boolean accept(File pathname) {
        String name = pathname.getName().toLowerCase();
        return name.endsWith(".h") || (pathname.isDirectory() && !("System Volume Information".equalsIgnoreCase(name)));
    }
});