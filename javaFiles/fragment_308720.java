private void addToZipFolder(Folder folder, ZipArchiveOutputStream zos) throws IOException {
    String path = folder.getPaths().get(0).replace(sito_export_path, "");
    ZipArchiveEntry zipEntry = new ZipArchiveEntry(path.concat("/"));
    appLog.info("aggiungo cartella vuota "+folder.getName()+" al file zip");
    zos.putArchiveEntry(zipEntry);
    zos.closeArchiveEntry();
}

private void addToZipFile(Document document, ZipArchiveOutputStream zos) throws IOException {
    InputStream inputStream = document.getContentStream().getStream();
    String path = document.getPaths().get(0).replace(sito_export_path, "");
    ZipArchiveEntry entry = new ZipArchiveEntry(path);
    entry.setSize(document.getContentStreamLength());
    zos.putArchiveEntry(entry);
    byte buffer[] = new byte[1024];
    while (true) {
        int nRead = inputStream.read(buffer, 0, buffer.length);
        if (nRead <= 0) {
            break;
        }
        zos.write(buffer, 0, nRead);
    }
    inputStream.close();
    zos.closeArchiveEntry();
}