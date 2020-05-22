class FileFormat {
    private File delegate;
    FileFormat (File delegate) {
       this.delegate = delegate;
    }
    public String toString() {
       return formatAllPrettyAndWhatNot (delegate);
    }
};
//then use a ArrayList<FileFormat>(), in your array spinner adapter