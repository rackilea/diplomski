public static void removeFileAndParentsIfEmpty(Path path)
        throws IOException {
    if(path == null || path.endsWith(BASEPATH)) return;

    if (Files.isRegularFile(path)) {
        Files.deleteIfExists(path);
    } else if(Files.isDirectory(path)) {
        try {
            Files.delete(path);
        } catch(DirectoryNotEmptyException e) {
            return;
        }
    }

    removeFileAndParentsIfEmpty(path.getParent());
}