ZipEntry entry;
while ((entry = zis.getNextEntry()) != null) {
    String name = entry.getName();
    if (iWantToProcessThisEntry(name)) {
        processFile(name, zis);
    }
    zis.closeEntry();
}

public void processFile(String name, InputStream in) throws IOException { /* ... */ }