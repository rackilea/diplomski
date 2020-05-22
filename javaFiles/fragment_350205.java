public static File[] getDirectoryList(File file) {
    File[] files = file.listFiles(new FileFilter() {
        public boolean accept(File file) {
            return file.isDirectory();
        }
    });
    return files;
}