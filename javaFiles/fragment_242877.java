public List<ZipEntry> extractZipEntries(byte[] content) throws IOException {
    List<ZipEntry> entries = new ArrayList<>();

    ZipInputStream zi = null;
    try {
        zi = new ZipInputStream(new ByteArrayInputStream(content));

        ZipEntry zipEntry = null;
        while ((zipEntry = zi.getNextEntry()) != null) {
            entries.add(zipEntry);
        }
    } finally {
        if (zi != null) {
            zi.close();
        }
    }
    return entries;
}