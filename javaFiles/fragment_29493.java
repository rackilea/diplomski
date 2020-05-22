File f = new File("."); // Cuncurrent directory
File[] files = f.listFiles(new FileFilter() {
    public boolean accept(File fi) {
        return fi.getName().match("[0-9a-f-]{36}");
    }
});
for(File file : files) {
    file.delete();
}