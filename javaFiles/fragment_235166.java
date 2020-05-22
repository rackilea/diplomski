class FileTypeComparator implements Comparator<File> {

    @Override
    public int compare(File file1, File file2) {

        if (file1.isDirectory() && file2.isFile())
            return -1;
        if (file1.isDirectory() && file2.isDirectory()) {
            return 0;
        }
        if (file1.isFile() && file2.isFile()) {
            return 0;
        }
        return 1;
    }
}