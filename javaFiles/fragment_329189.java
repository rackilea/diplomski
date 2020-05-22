private static final File LOCATION = new File("/path/to/all/uploads");

public void upload() throws IOException {
    if (file != null) {
        String prefix = FilenameUtils.getBaseName(file.getName()); 
        String suffix = FilenameUtils.getExtension(file.getName());
        File save = File.createTempFile(prefix + "-", "." + suffix, LOCATION);
        Files.write(save.toPath(), file.getContents());
        // Add success message here.
    }
}