public class MyZip {

    public static class MemoryFile {
        public String fileName;
        public byte[] contents;
    }

    public byte[] createZipByteArray(List<MemoryFile> memoryFiles) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
        try {
            for (MemoryFile memoryFile : memoryFiles) {
                ZipEntry zipEntry = new ZipEntry(memoryFile.fileName);
                zipOutputStream.putNextEntry(zipEntry);
                zipOutputStream.write(memoryFile.contents);
                zipOutputStream.closeEntry();
            }
        } finally {
            zipOutputStream.close();
        }
        return byteArrayOutputStream.toByteArray();
    }

}