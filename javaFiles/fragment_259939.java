File dir = new File("/your/dir");
File[] files = dir.listFiles(new FilenameFilter() {
    public boolean accept(File dir, String name) {
        return name.toLowerCase().endsWith(".wav"); 
    }
});