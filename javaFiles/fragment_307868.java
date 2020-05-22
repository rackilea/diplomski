/**
 * Combine multiple zipfiles together
 * @param files List of file objects pointing to zipfiles
 * @param ids List of file names to use in the final output
 * @return The byte[] object representing the final output
 * @throws IOException When there was a problem reading a zipfile
 * @throws NullPointerException When there either input is or contains a null value
 */
private byte[] zipFiles(ArrayList<File> files, String[] ids) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();

    // Buffer to copy multiple bytes at once, this is generally faster that just reading and writing 1 byte at a time like your previous code does
    byte[] buf = new byte[16 * 1024];
    int length = files.size();
    assert length == ids.length;
    try (ZipOutputStream zos = new ZipOutputStream(baos)) {
        for (int i = 0; i < length; i++) {
            try (ZipInputStream inStream = new ZipInputStream(new FileInputStream(files.get(i))) {
                ZipEntry entry;
                while ((entry = inStream.getNextEntry()) != null) {
                    zos.putNextEntry(new ZipEntry(ids[i] + "/" + entry.getName()));
                    int readLength;
                    while ((readLength = inStream.read(buf)) > 0) {
                        zos.write(buf, 0, readLength);
                    }
                }
            }
        }
    }

    return baos.toByteArray();
}