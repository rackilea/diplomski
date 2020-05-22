public enum PdfFileNameFilter implements FilenameFilter {
    INSTANCE;

    public boolean accept(File dir, String name) {
        return (name.toLowerCase().endsWith(".pdf"));
    }
}