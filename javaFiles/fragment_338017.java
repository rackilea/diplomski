// your directory
File f = new File("src");
File[] matchingFiles = f.listFiles(new FilenameFilter() {
    public boolean accept(File dir, String name) {
        return name.startsWith("lager") && name.endsWith("jrxml");
    }
});