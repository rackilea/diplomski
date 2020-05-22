public static void main(String[] args) throws IOException {
    // ** specify an output directory to copy files to
    final File outDir = new File("path\\to\\...\\OutDir");

    // ** read the zip input stream and do for each entry...
    final String pathToZip = "path\\to\\...\\ZipTest.zip";
    try (InputStream is = new FileInputStream(pathToZip);
            ZipInputStream zis = new ZipInputStream(is);) {

        forEachZipEntry(zis, (zipEntry, subZipStream) -> {
            // ** specify how to consume each zip entry and stream...
            // ** apply filters here, based on the zip entry
            if (zipEntry.getName().equals("normalZippedDir.zip")) {
                // ** copy the zip stream to the file
                File outFile = new File(outDir, zipEntry.getName());
                try (FileOutputStream fis = new FileOutputStream(outFile);) {
                    // apache IOUtils or whatever copy method you want
                    IOUtils.copy(subZipStream, fis);
                } catch (IOException e) { e.printStackTrace(); }
            }
        });
    }
}

/**
 * Iterates through all {@linkplain ZipEntry}s of the given {@linkplain ZipInputStream} and and
 * passes the current zip entry and stream to the provided {@linkplain BiConsumer}, but does
 * <b>not</b> recursively parse entries of nested zip files.
 */
public static void forEachZipEntry(ZipInputStream zis, BiConsumer<ZipEntry, ZipInputStream> consumer)
        throws IOException {
    Objects.requireNonNull(zis);
    Objects.requireNonNull(consumer);
    ZipEntry entry;
    while ((entry = zis.getNextEntry()) != null) {
        consumer.accept(entry, zis);
    }
}

/**
 * Recursively iterates through <b>all</b> {@linkplain ZipEntry}s <i>(including entries of nested zip
 * files)</i> of the given {@linkplain ZipInputStream} passing the current zip entry and stream to
 * the provided {@linkplain BiConsumer}.
 */
public static void forEachZipEntryRecursive(ZipInputStream zis,
        BiConsumer<ZipEntry, ZipInputStream> consumer) throws IOException {
    Objects.requireNonNull(zis);
    Objects.requireNonNull(consumer);
    ZipEntry entry;
    while ((entry = zis.getNextEntry()) != null) {
        consumer.accept(entry, zis);
        @SuppressWarnings("resource") // ** caller shall close `zis`
        ZipInputStream subZis = new ZipInputStream(zis);
        forEachZipEntryRecursive(subZis, consumer);
    }
}