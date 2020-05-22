public File getLastModifiedFile(File directory) {
    File[] files = directory.listFiles();
   if (files.length == 0) return null;
    Arrays.sort(files, new Comparator<File>() {
        public int compare(File o1, File o2) {
            return new Long(o2.lastModified()).compareTo(o1.lastModified()); 
        }});
    return files[0];
}