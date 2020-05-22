public List<File> unzipToTemporaryFolder(ZipInputStream inputStream,
        File tempFile) throws IOException {
    List<File> files = new LinkedList<File>();
    int count;
    byte[] buffer = new byte[BUFFER];

    org.apache.commons.compress.archivers.zip.ZipFile zf = new org.apache.commons.compress.archivers.zip.ZipFile(tempFile, "UTF-8");
    Enumeration<?> entires = zf.getEntries();
    while(entires.hasMoreElements()) {
        org.apache.commons.compress.archivers.zip.ZipArchiveEntry entry = (org.apache.commons.compress.archivers.zip.ZipArchiveEntry)entires.nextElement();
        if(entry.isDirectory()) {
            unzipDirectoryZipEntry(files, entry);
        } else {            
            InputStream zin = zf.getInputStream(entry);                 

            File temp = File.createTempFile(entry.getName().substring(0, entry.getName().length() - 4) + "-", "." + entry.getName().substring(entry.getName().length() - 3, entry.getName().length()));                                     

            OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(temp), BUFFER);
            while ((count = zin.read(buffer, 0, BUFFER)) != -1) {
                outputStream.write(buffer, 0, count);
            }
            outputStream.flush();
            zin.close();
            outputStream.close();
            files.add(temp);            
        }
    }
    zf.close();
    return files;
}