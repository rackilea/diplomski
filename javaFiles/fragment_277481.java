public static void mergeFiles(List<File> files, File into)
        throws IOException {
    try (FileOutputStream fos = new FileOutputStream(into);
         BufferedOutputStream mergingStream = new BufferedOutputStream(fos)) {
        for (File f : files) {
            Files.copy(f.toPath(), mergingStream);
        }
    }
}