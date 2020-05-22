public static void main(String[] args) {
    try {
        copyJarFromZip("G:\\Dateien\\Desktop\\Desktop.zip",
                       "G:\\Dateien\\Desktop\\someJar.jar");
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}

public static void copyJarFromZip(final String zipPath, final String targetPath) throws IOException {
    try (ZipFile zipFile = new ZipFile(zipPath)) {
        for (final Enumeration<? extends ZipEntry> e = zipFile.entries(); e.hasMoreElements();) {
            ZipEntry zipEntry = e.nextElement();
            if (zipEntry.getName().endsWith(".jar")) {
                Files.copy(zipFile.getInputStream(zipEntry), Paths.get(targetPath),
                           StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }
}