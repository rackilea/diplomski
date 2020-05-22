Arrays.sort(ftpfiles, new Comparator<FTPFile>() {
    @Override
    public int compare(FTPFile o1, FTPFile o2) {
        return o2.lastModified().compareTo(o1.lastModified());
    }
});