File dir = new File("/path/to/directory");
File[] foundFiles = dir.listFiles(new FilenameFilter() {
    public boolean accept(File dir, String name) {
        return name.startsWith("Ab-");
    }
});

for (File file : foundFiles) {
    // Process file
}