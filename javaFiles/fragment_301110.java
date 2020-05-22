File[] files = new File("screenshots").listFiles(new FileFilter() {
    @Override
    public boolean accept(File pathname) {
        return pathname.getName().startsWith("screenshot");
    }
});
int counter = files.length + 1;