public static File lastFileModified(String dir) {
    File fl = new File(dir);
    File[] files = fl.listFiles(new FileFilter() {          
        public boolean accept(File file) {
            return file.isFile();
        }
    });
    long lastMod = Long.MIN_VALUE;
    File choise = null;
    for (File file : files) {
        if (file.lastModified() > lastMod) {
            choise = file;
            lastMod = file.lastModified();
        }
    }
    return choise;
}