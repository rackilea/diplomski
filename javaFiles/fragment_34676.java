public static void unzip(String targetDir, String zipFilename) {
    Path targetDirPath = Paths.get(targetDir);
    try (ZipFile zipFile = new ZipFile(zipFilename)) {
        zipFile.stream()
               .parallel() // enable multi-threading
               .forEach(e -> unzipEntry(zipFile, e, targetDirPath));
    } catch (IOException e) {
        throw new RuntimeException("Error opening zip file '" + zipFilename + "': " + e, e);
    }
}

private static void unzipEntry(ZipFile zipFile, ZipEntry entry, Path targetDir) {
    try {
        Path targetPath = targetDir.resolve(Paths.get(entry.getName()));
        if (Files.isDirectory(targetPath)) {
            Files.createDirectories(targetPath);
        } else {
            Files.createDirectories(targetPath.getParent());
            try (InputStream in = zipFile.getInputStream(entry)) {
                Files.copy(in, targetPath, StandardCopyOption.REPLACE_EXISTING);
            }
        }
    } catch (IOException e) {
        throw new RuntimeException("Error processing zip entry '" + entry.getName() + "': " + e, e);
    }
}