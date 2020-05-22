public class FileExtensionFilter implements FilenameFilter {
    private Set<String> filteredExtensions;
    public FileExtensionFilter() {
        filteredExtensions = new HashSet<String>();
    }
    @Override
    public boolean accept(File dir, String name) {
        boolean accept = true;
        for (String filteredExtension:filteredExtensions) {
            accept = accept && !name.endsWith(filteredExtension);
        }
        return accept;
    }
    public void addFilteredExtension(String extension) {
        filteredExtensions.add(extension);
    }
}