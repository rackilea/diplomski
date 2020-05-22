public static void createZip(Path zipLocation, Path toBeAdded, String internalPath) throws Throwable {
    Map<String, String> env = new HashMap<String, String>();
    // check if file exists
    env.put("create", String.valueOf(Files.notExists(zipLocation)));
    // use a Zip filesystem URI
    URI fileUri = zipLocation.toUri(); // here
    URI zipUri = new URI("jar:" + fileUri.getScheme(), fileUri.getPath(), null);
    System.out.println(zipUri);
    // URI uri = URI.create("jar:file:"+zipLocation); // here creates the
    // zip
    // try with resource
    try (FileSystem zipfs = FileSystems.newFileSystem(zipUri, env)) {
        // Create internal path in the zipfs
        Path internalTargetPath = zipfs.getPath(internalPath);
        // Create parent directory
        Files.createDirectories(internalTargetPath.getParent());
        // copy a file into the zip file
        Files.copy(toBeAdded, internalTargetPath, StandardCopyOption.REPLACE_EXISTING);
    }
}

public static void main(String[] args) throws Throwable {
    Path zipLocation = FileSystems.getDefault().getPath("a.zip").toAbsolutePath();
    Path toBeAdded = FileSystems.getDefault().getPath("a.txt").toAbsolutePath();
    createZip(zipLocation, toBeAdded, "aa/aa.txt");
}