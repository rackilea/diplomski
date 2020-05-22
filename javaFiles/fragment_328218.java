String entryName = // put name of your entry here
File file = // put your zip file here
ZipFile zipFile = null;
try {
    zipFile = ZipFile(file);
    ZipEntry zipEntry = zipFile.getEntry(entryName);
    InputStream is = null;
    try {
        is = zipFile.getInputStream(zipEntry);
        // read stream here e.g. using BufferedReader
    } catch (IOException ex) {
        // TODO: handle exception or delete catch block
    } finally {
        if (is != null) {
            try {
                is.close();
            } catch (IOException ex) {
            }
        }
    }
} finally {
    if (zipFile != null) {
        zipFile.close();
    }
}