Comparator<File> stringLengthComparator = new Comparator<File>() {
    @Override
    public int compare(File o1, File o2) {
        return Integer.valueOf((int) (o1.length() / 1000)).compareTo(Integer.valueOf((int) (o2.length() / 1000)));
    }
};