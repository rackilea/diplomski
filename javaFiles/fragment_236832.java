File[] files = dir.istFiles();
Array.sort(files, new Comparator<File> {
    @Override
    public int compare(File lhs, File rhs) {
        //return -1 if lhs should go before
        //0 if it doesn't matter
        //1 if rhs should go after
    }
});