public Path getRootPath(FileStore fs) throws IOException {
    Path media = Paths.get("/media");
    if (media.isAbsolute() && Files.exists(media)) { // Linux
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(media)) {
            for (Path p : stream) {
                if (Files.getFileStore(p).equals(fs)) {
                    return p;
                }
            }
        }
    } else { // Windows
        IOException ex = null;
        for (Path p : FileSystems.getDefault().getRootDirectories()) {
            try {
                if (Files.getFileStore(p).equals(fs)) {
                    return p;
                }
            } catch (IOException e) {
                ex = e;
            }
        }
        if (ex != null) {
            throw ex;
        }
    }
    return null;
}