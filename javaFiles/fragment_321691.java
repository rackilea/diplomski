public Set<String> checkForExtensions(File file) {
    Set<String> extensions = new HashSet<String>();
    if (file.isDirectory()) {
        for (File f : file.listFiles(fileExtensionFilter)) {
            extensions.addAll(checkForExtensions(f));
        }
    } else {
        //NOTE: if you don't want the '.' in the extension you'll need to add a '+1' to the substring call
        String extension = file.getName().substring(Math.max(file.getName().lastIndexOf('.'),0));
        extensions.add(extension);
        fileExtensionFilter.addFilteredExtension(extension);
    }
    return extensions;
}