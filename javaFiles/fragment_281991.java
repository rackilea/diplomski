private void sortByName(File[] files){
     Arrays.sort(files, new Comparator<File>() {
        @Override
        public int compare(File t, File t1) {
            return t.getName().compareTo(t1.getName());
        }
    });
}

private void sortByDate(File[] files){
    Arrays.sort(files, new Comparator<File>() {
        @Override
        public int compare(File t, File t1) {
            return (int) (t.lastModified() - t1.lastModified());
        }
    });
}

private void sortBySize(File[] files){
     Arrays.sort(files, new Comparator<File>() {
        @Override
        public int compare(File t, File t1) {
            return (int) (t.length() - t1.length());
        }
    });
}